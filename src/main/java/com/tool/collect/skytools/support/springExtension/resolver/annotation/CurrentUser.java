package com.tool.collect.skytools.support.springExtension.resolver.annotation;

import java.lang.annotation.*;

/**
 * 绑定当前登录的用户,不同于@ModelAttribute
 *
 * @author Gnoll
 * @create 2017-06-16 17:00
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {

    /**
     * 当前用户在request中的名字
     *
     * @return
     */
    String value() default "user";
}
