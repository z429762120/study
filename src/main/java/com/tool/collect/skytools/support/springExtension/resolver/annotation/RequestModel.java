package com.tool.collect.skytools.support.springExtension.resolver.annotation;

import java.lang.annotation.*;

/**
 * 绑定请求参数到模型,使用value值为前缀,如：company.name company.city
 *
 * @author Gnoll
 * @create 2017-06-16 17:00
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestModel {
    String value();
    boolean require() default true;
}
