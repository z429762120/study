package com.tool.collect.skytools.support.hibernateExtension.annotaion;


import com.tool.collect.skytools.support.hibernateExtension.validator.DigitalValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * 检查字串是否全由数字组成
 *
 * @author Gnoll
 * @create 2017-06-16 19:42
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = DigitalValidator.class)
public @interface Digital {

    long min() default 0L;

    long max() default Long.MAX_VALUE;

    String message() default "{com.aimymusic.appserver.validator.Digital.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Digital[] value();
    }
}
