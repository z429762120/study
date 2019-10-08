package com.tool.collect.skytools.support.hibernateExtension.annotaion;

import com.tool.collect.skytools.support.hibernateExtension.validator.StringBytelengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by bo on 2018/01/24.
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = StringBytelengthValidator.class)
public @interface StringByteLength {
    int min() default 0;

    int max() default Integer.MAX_VALUE;

    String message() default "{org.hibernate.validator.constraints.StringByteLength.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@code @Range} annotations on the same element.
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        StringByteLength[] value();
    }
}
