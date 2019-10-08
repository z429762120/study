package com.tool.collect.skytools.support.hibernateExtension.validator;


import com.tool.collect.skytools.support.hibernateExtension.annotaion.Digital;
import com.tool.collect.skytools.support.utility.StringUtility;
import com.tool.collect.skytools.support.utility.ValidatorUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 检查字串是否全由数字组成
 *
 * @author Gnoll
 * @create 2017-06-16 19:42
 */

public class DigitalValidator implements ConstraintValidator<Digital, String> {

    private long min;
    private long max;

    @Override
    public void initialize(Digital constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtility.hasText(value)) {
            return true;
        }

        if (!ValidatorUtility.isNumeric(value)) {
            return false;
        }
        return value.length() >= min ? value.length() <= max : false;
    }

}
