package com.tool.collect.skytools.support.hibernateExtension.validator;


import com.tool.collect.skytools.support.hibernateExtension.annotaion.IntArray;
import com.tool.collect.skytools.support.utility.StringUtility;
import com.tool.collect.skytools.support.utility.ValidatorUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 验证数字数组
 * @author Gnoll
 * @create 2017-07-07 21:26
 **/
public class IntArrayValidator implements ConstraintValidator<IntArray,String> {

    private char separated;

    @Override
    public void initialize(IntArray constraintAnnotation) {
        separated = constraintAnnotation.separated();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!StringUtility.hasText(value)) return true;
        return ValidatorUtility.isIntArray(value,separated);
    }
}
