package com.tool.collect.skytools.support.exception.extension;

import java.util.Map;

/**
 * @author Gnoll
 * @create 2017-06-19 16:50
 **/
public interface ServiceExceptionBuilder {

    public ServiceExceptionBuilder setThrowType(String throwType);

    public ServiceExceptionBuilder setCode(int code);

    public ServiceExceptionBuilder setFields(Map<String, String> fields);

    public ServiceExceptionBuilder setMessage(String message);

    public ServiceExceptionBuilder setMessageParameters(Map<String, Object> messageParameters);

    public Exception build();
}
