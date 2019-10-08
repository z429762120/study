package com.tool.collect.skytools.support.hibernateExtension.validator;


import com.tool.collect.skytools.support.hibernateExtension.annotaion.Version;
import com.tool.collect.skytools.support.utility.StringUtility;
import com.tool.collect.skytools.support.utility.ValidatorUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 检查AppVersion格式
 * @author Gnoll
 * @create 2017-07-07 16:24
 **/
public class VersionValidator implements ConstraintValidator<Version, String> {

    @Override
    public void initialize(Version constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtility.hasText(value)) {
            return true;
        }
        return ValidatorUtility.checkAppVersion(value);
    }
}
