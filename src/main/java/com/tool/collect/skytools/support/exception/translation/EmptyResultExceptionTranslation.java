package com.tool.collect.skytools.support.exception.translation;


import com.tool.collect.skytools.support.constant.ErrorCode;
import com.tool.collect.skytools.support.exception.TranslationContext;
import com.tool.collect.skytools.support.exception.annotation.ExpTranslation;
import com.tool.collect.skytools.support.springExtension.view.UnifyFailureView;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.servlet.view.AbstractView;

/**
 * 查询结果空异常，输出Code=404
 *
 * @author Gnoll
 * @create 2017-06-19 19:57
 **/
@ExpTranslation
public class EmptyResultExceptionTranslation extends AbstractExceptionTranslation{

    @Override
    public boolean support(Exception ex) {
        return ex instanceof EmptyResultDataAccessException;
    }

    @Override
    public AbstractView translationToJson(TranslationContext context) {
        AbstractView view = new UnifyFailureView();
        view.addStaticAttribute(CODE, ErrorCode.ResourceNotFound.getCode());
        view.addStaticAttribute(THROWTYPE, getThrowtype(context.getException()));
        view.addStaticAttribute(MESSAGE, interpolate(ErrorCode.ResourceNotFound.getTemplate(),null));
        return view;
    }
}
