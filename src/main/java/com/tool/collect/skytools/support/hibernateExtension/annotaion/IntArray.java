package com.tool.collect.skytools.support.hibernateExtension.annotaion;

import com.tool.collect.skytools.support.hibernateExtension.validator.IntArrayValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Gnoll on 2017/7/7.
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = IntArrayValidator.class)
public @interface IntArray {

    char separated() default ',';

    String message() default "{com.aimymusic.appserver.validator.IntArray.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        IntArray[] value();
    }
}
