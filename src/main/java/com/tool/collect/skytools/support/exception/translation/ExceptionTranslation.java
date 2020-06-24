package com.tool.collect.skytools.support.exception.translation;

import com.tool.collect.skytools.support.exception.TranslationContext;
import org.springframework.web.servlet.view.AbstractView;

/**
 * 异常转换器接口
 *
 * @author Gnoll
 * @create 2017-06-19 18:06
 **/
public interface ExceptionTranslation {
    /**
     * 检查是否支持
     *
     * @param ex
     * @return
     */
    boolean support(Exception ex);

    /**
     * 转换成JSON
     *
     * @param context
     * @return
     */
    AbstractView translationToJson(TranslationContext context);
}
