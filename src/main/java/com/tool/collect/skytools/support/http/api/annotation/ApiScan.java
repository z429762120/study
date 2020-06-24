package com.tool.collect.skytools.support.http.api.annotation;

import com.tool.collect.skytools.support.http.api.config.ApiRegister;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created by Gnoll on 2017/6/30.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ApiRegister.class)
public @interface ApiScan {
    @AliasFor(attribute = "scanPackage")
    String value() default "";
    @AliasFor(attribute = "value")
    String scanPackage() default "";
}
