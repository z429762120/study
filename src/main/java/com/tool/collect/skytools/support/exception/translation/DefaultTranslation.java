package com.tool.collect.skytools.support.exception.translation;


import com.tool.collect.skytools.support.constant.ErrorCode;
import com.tool.collect.skytools.support.exception.TranslationContext;
import com.tool.collect.skytools.support.springExtension.view.UnifyFailureView;
import org.springframework.web.servlet.view.AbstractView;


/**
 * 默认异常转换器，输出Code=500
 *
 * @author Gnoll
 * @create 2017-06-19 19:56
 **/
public class DefaultTranslation extends AbstractExceptionTranslation {
    @Override
    public boolean support(Exception ex) {
        return true;
    }

    @Override
    public AbstractView translationToJson(TranslationContext context) {
        AbstractView view = new UnifyFailureView();
        view.addStaticAttribute(CODE, ErrorCode.Server.getCode());
        view.addStaticAttribute(THROWTYPE,getThrowtype(context.getException()));
        view.addStaticAttribute(MESSAGE,interpolate(ErrorCode.Server.getTemplate(),null));
        view.addStaticAttribute(DETAILMESSAGE, context.getException().getLocalizedMessage());
        return view;
    }
}
