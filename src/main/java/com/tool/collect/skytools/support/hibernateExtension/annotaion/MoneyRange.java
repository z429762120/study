package com.tool.collect.skytools.support.hibernateExtension.annotaion;


import com.tool.collect.skytools.support.hibernateExtension.validator.MoneyRangeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * 金额检查
 *
 * @author Gnoll
 * @create 2017-06-16 19:42
 */
@Documented
@Constraint(validatedBy = MoneyRangeValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface MoneyRange {
    double min() default 0.01D;

    double max() default Double.MAX_VALUE;

    String message() default "{com.aimymusic.appserver.validator.MoneyRange.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    /**
     * Defines several {@code @Range} annotations on the same element.
     */
    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        MoneyRange[] value();
    }
}
