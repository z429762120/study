package com.tool.collect.skytools.support.exception;

import lombok.Getter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常转换上下文
 *
 * @author Gnoll
 * @create 2017-06-19 18:08
 **/
@Getter
public class TranslationContext {

    HttpServletRequest request;

    HttpServletResponse response;

    Object handler;

    Exception exception;

    String[] jsonp;

    public TranslationContext(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) {
        this(request, response, handler, exception, null);
    }

    public TranslationContext(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception, String[] jsonp) {
        this.request = request;
        this.response = response;
        this.handler = handler;
        this.exception = exception;
        this.jsonp = jsonp;
    }
}
