package com.tool.collect.skytools.support.aop.annotation;

import java.lang.annotation.*;

/**
 * 测试
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AspectInfo {
    String value() default "";
}
