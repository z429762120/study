package com.tool.collect.skytools.support.hibernateExtension.validator;


import com.tool.collect.skytools.support.hibernateExtension.annotaion.MobilePhone;
import com.tool.collect.skytools.support.utility.StringUtility;
import com.tool.collect.skytools.support.utility.ValidatorUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * 手机号码验证
 *
 * @author Gnoll
 * @create 2017-06-16 19:42
 */
public class MobilePhoneValidator implements ConstraintValidator<MobilePhone, String> {

    public void initialize(MobilePhone arg0) {
    }

    public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
        if (!StringUtility.hasText(arg0)) return true;
        return ValidatorUtility.isMobile(arg0);
    }
}
