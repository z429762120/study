package com.tool.collect.skytools.support.hibernateExtension.validator;


import com.tool.collect.skytools.support.hibernateExtension.annotaion.Phone;
import com.tool.collect.skytools.support.utility.StringUtility;
import com.tool.collect.skytools.support.utility.ValidatorUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * 验证固定电话或手机号码
 *
 * @author Gnoll
 * @create 2017-06-16 19:42
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    @Override
    public void initialize(Phone constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtility.hasText(value)) return true;
        return ValidatorUtility.isTelephoeNo(value) || ValidatorUtility.isMobile(value);
    }

}
