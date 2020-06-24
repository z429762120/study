package com.tool.collect.skytools.support.exception;


import com.tool.collect.skytools.support.exception.annotation.ExpTranslation;
import com.tool.collect.skytools.support.exception.annotation.TranslationScan;
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
 * 注册Translation类
 *
 * @author Gnoll
 * @create 2017-06-20 16:47
 **/
public class TranslationRegister implements ImportBeanDefinitionRegistrar {

    private static final Log log = LoggerFactory.make();

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        AnnotationAttributes annoAttrs = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(TranslationScan.class.getName()));
        String values = annoAttrs.getString("value");
        try {
            Set<Class<?>> classes = ReflectionUtility.loadClassesByAnnotationClass(
                    ExpTranslation.class, values.split(","));
            classes.forEach(aClass -> {
                GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
                beanDefinition.setSynthetic(true);
                beanDefinition.setBeanClass(aClass);
                registry.registerBeanDefinition(aClass.getSimpleName(),beanDefinition);
            });
        } catch (IOException e) {
            log.error("Exception translation register error",e);
        } catch (ClassNotFoundException e) {
            log.error("Exception translation register error",e);
        }
    }
}
