package com.tool.collect.skytools.support.hibernateExtension.validator;

import com.tool.collect.skytools.support.hibernateExtension.annotaion.EnumValue;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * 验证枚举字段的取值范围
 *
 * @author Gnoll
 * @create 2017-06-16 19:42
 */
public class EnumValueValidator implements ConstraintValidator<EnumValue, Integer> {
    int enumLength;

    public void initialize(EnumValue constraintAnnotation) {
        enumLength = constraintAnnotation.clazz().getEnumConstants().length;
    }

    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (context instanceof HibernateConstraintValidatorContext) {
            HibernateConstraintValidatorContext validatorContext = (HibernateConstraintValidatorContext) context;
            validatorContext.addExpressionVariable("min", 0);
            validatorContext.addExpressionVariable("max", enumLength - 1);
        }

        if (null == value) {
            return true;
        }
        return enumLength > value;
    }
}
