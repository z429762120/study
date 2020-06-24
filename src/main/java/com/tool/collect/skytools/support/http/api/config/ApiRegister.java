package com.tool.collect.skytools.support.http.api.config;


import com.tool.collect.skytools.support.http.api.annotation.Api;
import com.tool.collect.skytools.support.http.api.annotation.ApiScan;
import com.tool.collect.skytools.support.utility.ReflectionUtility;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.io.IOException;
import java.util.Set;

/**
 * @author Gnoll
 * @create 2017-07-01 12:12
 **/
public class ApiRegister implements ImportBeanDefinitionRegistrar {

    private static final Log log = LoggerFactory.make();

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(ApiScan.class.getName()));
        String scanPackage = annoAttrs.getString("value");
        try {
            Set<Class<?>> classes = ReflectionUtility.loadClassesByAnnotationClass(
                    Api.class, scanPackage.split(","));
            classes.forEach(aClass -> {
                GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
                beanDefinition.setSynthetic(true);
                beanDefinition.setBeanClass(aClass);
                registry.registerBeanDefinition(aClass.getSimpleName(),beanDefinition);
            });
        } catch (IOException e) {
            log.error("Api register error",e);
        } catch (ClassNotFoundException e) {
            log.error("Api register error",e);
        }
    }
}
