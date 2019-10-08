package com.tool.collect.skytools.support.controller;

import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gnoll
 * @create 2017-07-07 12:02
 **/
public abstract class HttpServletController {
    @Autowired
    protected HttpServletRequest request;
    @Autowired
    protected HttpServletResponse response;

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }
}
