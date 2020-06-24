package com.tool.collect.skytools.support.http.api.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created by Gnoll on 2017/6/30.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Api {
    @AliasFor(attribute = "name")
    String value() default "default";

    @AliasFor(attribute = "value")
    String name() default "default";
}
