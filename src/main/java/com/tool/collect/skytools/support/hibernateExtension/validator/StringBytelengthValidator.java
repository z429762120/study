package com.tool.collect.skytools.support.hibernateExtension.validator;


import com.tool.collect.skytools.support.hibernateExtension.annotaion.StringByteLength;
import com.tool.collect.skytools.support.utility.StringUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author bo
 * @create 2018-01-24 20:36
 **/
public class StringBytelengthValidator implements ConstraintValidator<StringByteLength, String> {
    private int min;
    private int max;

    @Override
    public void initialize(StringByteLength constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtility.hasText(value)) return true;
        int length = StringUtility.getStringByte(value);
        return length <= max && length >= min;
    }
}
