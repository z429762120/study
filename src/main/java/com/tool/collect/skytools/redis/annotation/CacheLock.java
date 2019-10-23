package com.tool.collect.skytools.redis.annotation;

import java.lang.annotation.*;

/**
 * 缓存锁，方法注解，标明的方法将获取缓存锁
 * <p>
 * Created by Gnoll on 2017/8/3.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheLock {
    String value() default "";                           // 如果此参数不为空，将默认为方法锁

    String lockedPrefix() default "LOCK_DEFAULT";        // 锁名前缀

    long timeOut() default 2000;                         // 取锁超时时间,单位纳秒

    long expireTime() default 60;                        // 锁过期时间
}
