package com.tool.collect.skytools.support.rateLimit;

import java.lang.annotation.*;

/**
 * 方法限流
 *
 * @author yangran
 * @create 2017/8/18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Limiter {
    String value() default "";

    int count() default 10;    //并发任务数
}
