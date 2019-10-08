package com.tool.collect.skytools.support.hibernateExtension.annotaion;


import com.tool.collect.skytools.support.hibernateExtension.validator.MobilePhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


/**
 * 手机号码验证注解
 *
 * @author Gnoll
 * @create 2017-06-16 19:42
 */
@Target({METHOD, FIELD, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = MobilePhoneValidator.class)
public @interface MobilePhone {

    String message() default "{com.aimymusic.appserver.validator.MobilePhone.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
    @Retention(RUNTIME)
    @Documented
    @interface List {

        MobilePhone[] value();
    }
}
