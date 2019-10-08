package com.tool.collect.skytools.support.hibernateExtension.validator;


import com.tool.collect.skytools.support.hibernateExtension.annotaion.StringJson;
import com.tool.collect.skytools.support.utility.StringUtility;
import com.tool.collect.skytools.support.utility.ValidatorUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Gnoll
 * @create 2017-07-18 20:40
 **/
public class StringJsonValidator implements ConstraintValidator<StringJson, String> {
    @Override
    public void initialize(StringJson constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(!StringUtility.hasLength(value)) return true;
        return ValidatorUtility.isJsonString(value);
    }
}
