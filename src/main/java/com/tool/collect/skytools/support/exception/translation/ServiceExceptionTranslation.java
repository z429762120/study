package com.tool.collect.skytools.support.exception.translation;


import com.tool.collect.skytools.support.exception.TranslationContext;
import com.tool.collect.skytools.support.exception.annotation.ExpTranslation;
import com.tool.collect.skytools.support.exception.extension.ExceptionInterface;
import com.tool.collect.skytools.support.springExtension.view.UnifyFailureView;
import com.tool.collect.skytools.support.utility.StringUtility;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.springframework.web.servlet.view.AbstractView;

import java.lang.reflect.UndeclaredThrowableException;
import java.util.Map;

/**
 * 抛出异常转换器。处理主动抛出的异常，{@link ExceptionInterface}
 *
 * @author Gnoll
 * @create 2017-06-19 19:57
 **/
@ExpTranslation
public class ServiceExceptionTranslation extends AbstractExceptionTranslation {

    @Override
    public boolean support(Exception ex) {
        if (ex instanceof UndeclaredThrowableException) {
            UndeclaredThrowableException exception = (UndeclaredThrowableException) ex;
            Throwable undeclaredThrowable = exception.getUndeclaredThrowable();
            ex = (Exception) undeclaredThrowable;
        }
        return ex instanceof ExceptionInterface;
    }

    @Override
    public AbstractView translationToJson(TranslationContext context) {
        ExceptionInterface anInterface;
        if (context.getException() instanceof UndeclaredThrowableException) {
            UndeclaredThrowableException exception = (UndeclaredThrowableException) context.getException();
            Throwable undeclaredThrowable = exception.getUndeclaredThrowable();
            anInterface = (ExceptionInterface) undeclaredThrowable;
        } else {
            anInterface = (ExceptionInterface) context.getException();
        }
        AbstractView view = new UnifyFailureView();
        view.addStaticAttribute(CODE, anInterface.getCode());
        String throwType = anInterface.getThrowType();
        if(StringUtility.isEmpty(throwType)) {
            throwType = getThrowtype((Exception) anInterface);
        }
        view.addStaticAttribute(THROWTYPE, throwType);
        String messageTemplate = anInterface.getMessageTemplate();
        MessageInterpolatorContext interpolatorContext = createInterpolatorContext(anInterface.getMessageParameters());
        if (StringUtility.hasText(messageTemplate)) {
            view.addStaticAttribute(MESSAGE, interpolateByMIContext(messageTemplate, interpolatorContext));
        } else {
            view.addStaticAttribute(MESSAGE, anInterface.getExceptionMessage());
        }
        Map<String, String> fields = anInterface.getFields();
        if (null != fields) {
            for (Map.Entry<String, String> entry : fields.entrySet()) {
                String value = entry.getValue();
                entry.setValue(interpolateByMIContext(value, interpolatorContext));
            }
        }
        view.addStaticAttribute(FIELDS, fields);
        return view;
    }


}
