package com.tool.collect.skytools.support.utility;

import com.tool.collect.skytools.dto.Person;
import com.tool.collect.skytools.support.exception.EXPF;
import org.hibernate.validator.internal.engine.ValidatorImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Gnoll
 * @create 2017-07-07 16:11
 **/
public class BeanValidatorUtility {
    private static ValidatorImpl validator;

    public BeanValidatorUtility(ApplicationContext context) {
        Validator bean = context.getBean(LocalValidatorFactoryBean.class);
        LocalValidatorFactoryBean validatorFactoryBean = (LocalValidatorFactoryBean) bean;
        validator = (ValidatorImpl) validatorFactoryBean.getValidator();
    }

    public static Set<ConstraintViolation<Object>> validBean(Object object, Class<?>... groups) {
        return validator.validate(object, groups);
    }

    public static Exception validBeanBackException(Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validBean(object, groups);
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            Map<String, String> error = new HashMap<>();
            constraintViolations.forEach(violation -> {
                String s = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                error.put(s, message);
            });
            return EXPF.E300(error, true);
        }
        return null;
    }

    public static Exception validBeanBackException(String prefix,Object object, Class<?>... groups) {
        Set<ConstraintViolation<Object>> constraintViolations = validBean(object, groups);
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            Map<String, String> error = new HashMap<>();
            constraintViolations.forEach(violation -> {
                String s = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                error.put(prefix+"."+s, message);
            });
            return EXPF.E300(error, true);
        }
        return null;
    }

    public static void main(String[] args) {
        Person p = new Person();
        p.setAge(1);
        javax.validation.Validator validator1 = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<Person>> constraintViolations = validator1.validate(p);
        if (!CollectionUtils.isEmpty(constraintViolations)) {
            Map<String, String> error = new HashMap<>();
            constraintViolations.forEach(violation -> {
                String s = violation.getPropertyPath().toString();
                String message = violation.getMessage();
                error.put(s, message);
            });

        }
    }
}
