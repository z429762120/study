package com.tool.collect.skytools.support.exception.translation;


import com.tool.collect.skytools.support.exception.TranslationContext;
import com.tool.collect.skytools.support.exception.annotation.ExpTranslation;
import com.tool.collect.skytools.support.exception.extension.ExceptionInterface;
import com.tool.collect.skytools.support.springExtension.view.UnifyFailureView;
import com.tool.collect.skytools.support.utility.StringUtility;
import org.hibernate.validator.internal.engine.MessageInterpolatorContext;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.web.servlet.view.AbstractView;

import java.util.Map;

/**
 * @author Gnoll
 * @create 2017-07-05 20:29
 **/
@ExpTranslation
public class RepositoryThrowTranslation extends AbstractExceptionTranslation {
    @Override
    public boolean support(Exception ex) {
        boolean b = ex instanceof InvalidDataAccessApiUsageException;
        if(b) {
            Throwable cause = ex.getCause();
            return cause instanceof ExceptionInterface;
        }
        return false;
    }

    @Override
    public AbstractView translationToJson(TranslationContext context) {
        ExceptionInterface anInterface = (ExceptionInterface) context.getException().getCause();
        AbstractView view = new UnifyFailureView();
        view.addStaticAttribute(CODE, anInterface.getCode());
        view.addStaticAttribute(THROWTYPE, anInterface.getThrowType());
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
