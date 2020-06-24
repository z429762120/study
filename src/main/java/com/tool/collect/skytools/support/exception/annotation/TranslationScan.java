package com.tool.collect.skytools.support.exception.annotation;

import com.tool.collect.skytools.support.exception.TranslationRegister;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author Gnoll
 * @create 2017-06-20 17:19
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(TranslationRegister.class)
public @interface TranslationScan {
    String value() default "";
}
