package com.tool.collect.skytools.support.aop.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IpIntercept {

    String[] value() default {""};
}
