package com.tool.collect.skytools.support.hibernateExtension.validator;


import com.tool.collect.skytools.support.hibernateExtension.annotaion.StringDate;
import com.tool.collect.skytools.support.utility.StringUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Gnoll
 * @create 2017-07-08 15:45
 **/
public class StringDateValidator implements ConstraintValidator<StringDate,String> {

    private String format;

    @Override
    public void initialize(StringDate constraintAnnotation) {
        format = constraintAnnotation.format();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtility.isEmpty(value)) return true;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        try {
            dateFormat.setLenient(false);
            dateFormat.parse(value);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
