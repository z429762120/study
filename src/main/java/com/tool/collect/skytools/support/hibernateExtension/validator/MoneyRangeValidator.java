package com.tool.collect.skytools.support.hibernateExtension.validator;


import com.tool.collect.skytools.support.hibernateExtension.annotaion.MoneyRange;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 金额范围检查类
 *
 * @author Gnoll
 * @create 2017-06-16 19:42
 */
public class MoneyRangeValidator implements ConstraintValidator<MoneyRange, Double> {

    private Double min;
    private Double max;

    @Override
    public void initialize(MoneyRange constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Double value, ConstraintValidatorContext context) {
        if (context instanceof HibernateConstraintValidatorContext) {
            HibernateConstraintValidatorContext hcontext = (HibernateConstraintValidatorContext) context;
            hcontext.addExpressionVariable("min", min);
            hcontext.addExpressionVariable("max", max);
        }
        return min <= value && max >= value;
    }
}
