package com.tool.collect.skytools.redis.annotation;

import java.lang.annotation.*;

/**
 * 参数锁
 * 基本类型参数直接使用此参数
 *
 * Created by Gnoll on 2017/8/3.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LockedObject {
    String value() default "";
}
