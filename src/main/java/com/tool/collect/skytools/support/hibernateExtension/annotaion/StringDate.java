package com.tool.collect.skytools.support.hibernateExtension.annotaion;

import com.tool.collect.skytools.support.hibernateExtension.validator.StringDateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Gnoll on 2017/7/8.
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = StringDateValidator.class)
public @interface StringDate {
    String format() default "yyyyMMddHHmmss";

    String message() default "{com.aimymusic.appserver.validator.StringDate.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        StringDate[] value();
    }
}
