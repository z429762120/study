package com.tool.collect.skytools.support.rateLimit;

import org.aspectj.lang.JoinPoint;
import org.springframework.util.StringUtils;

/**
 * @author yangran
 * @create 2017/8/19
 */
public class JoinPointToStringHelper {

    //返回   类名称.方法名称
    public static String toString(JoinPoint jp, Limiter limit) {
        if (limit != null && !StringUtils.isEmpty(limit.value())) {
            return limit.value();
        } else {
            String methodName = jp.getSignature().getName();
            String className = jp.getTarget().getClass().getName();
            return className.concat(".").concat(methodName);
        }
    }

}
