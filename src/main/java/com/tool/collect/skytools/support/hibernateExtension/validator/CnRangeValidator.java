package com.tool.collect.skytools.support.hibernateExtension.validator;


import com.tool.collect.skytools.support.hibernateExtension.annotaion.CnRange;
import com.tool.collect.skytools.support.utility.StringUtility;
import com.tool.collect.skytools.support.utility.ValidatorUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Gnoll
 * @create 2017-07-12 20:36
 **/
public class CnRangeValidator implements ConstraintValidator<CnRange, String> {
    private int min;
    private int max;
    private boolean isConfine;     // >= <=
    private boolean ignoreChinese; // 忽略中文，1中文=1字符

    @Override
    public void initialize(CnRange constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
        isConfine = constraintAnnotation.isConfine();
        ignoreChinese = constraintAnnotation.ignoreChinese();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (!StringUtility.hasText(value)) return true;
        return ValidatorUtility.isLengthScope(value,min,max,isConfine,ignoreChinese);
    }
}
