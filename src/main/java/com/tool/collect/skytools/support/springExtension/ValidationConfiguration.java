package com.tool.collect.skytools.support.springExtension;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.BeanValidationPostProcessor;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

/**
 * @author Gnoll
 * @create 2017-06-23 16:36
 **/
@Configuration
public class ValidationConfiguration {
    @Bean
    public BeanValidationPostProcessor beanValidationPostProcessor() {
        return new BeanValidationPostProcessor();
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }
}
