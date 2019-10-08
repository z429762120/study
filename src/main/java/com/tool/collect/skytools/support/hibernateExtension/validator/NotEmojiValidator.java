package com.tool.collect.skytools.support.hibernateExtension.validator;


import com.tool.collect.skytools.support.hibernateExtension.annotaion.NotEmoji;
import com.tool.collect.skytools.support.utility.StringUtility;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * emoji表情判断
 */
public class NotEmojiValidator implements ConstraintValidator<NotEmoji, String> {

    @Override
    public void initialize(NotEmoji constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtility.isEmpty(value)){ return true;}
        return !StringUtility.contrainEmoji(value);
    }


}
