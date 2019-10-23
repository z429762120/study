package com.tool.collect.skytools.support.aop;


import com.tool.collect.skytools.redis.RedisLock;
import com.tool.collect.skytools.redis.annotation.CacheLock;
import com.tool.collect.skytools.redis.annotation.LockedObject;
import com.tool.collect.skytools.support.constant.ErrorCode;
import com.tool.collect.skytools.support.exception.EXPF;
import com.tool.collect.skytools.support.utility.EntityPropertyUtility;
import com.tool.collect.skytools.support.utility.StringUtility;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.cache.RedisCacheKey;

import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 缓存锁切面
 *
 * @author Gnoll
 * @create 2017-08-04 10:30
 **/
@Aspect
@Order(4)  // 执行顺序
public class CacheLockAspect {

    @Autowired
    RedisLock redisLock;

    @Around("@annotation(cacheLock)")
    public Object around(ProceedingJoinPoint pjp, CacheLock cacheLock) throws Throwable {
        String prefix = cacheLock.lockedPrefix();
        String methodKey = cacheLock.value();
        RedisCacheKey cacheKey;
        if (StringUtility.hasLength(methodKey)) {
            cacheKey = redisLock.madeCacheKey(prefix, methodKey);
        } else {
            Object[] args = pjp.getArgs();
            MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
            Annotation[][] parameterAnnotations = methodSignature.getMethod().getParameterAnnotations();
            Object lockObject = getLockObject(parameterAnnotations, args);
            if(null == lockObject) return pjp.proceed();
            cacheKey = redisLock.madeCacheKey(prefix, lockObject);
        }
        Boolean lock = redisLock.lock(cacheKey, cacheLock.timeOut(), cacheLock.expireTime());
        if(!lock) {
            throw EXPF.exception(ErrorCode.InProgress,true); // 获取锁失败，业务处理中
        }
        try {
            return pjp.proceed();
        }finally {
            redisLock.unlock(cacheKey);
        }
    }


    private Object getLockObject(Annotation[][] annotations, Object[] args) {
        if (null == annotations || annotations.length == 0)
            throw new RuntimeException("Can not find @LockedObject[annotations Empty]");
        if (null == args || args.length == 0) throw new RuntimeException("Can not find @LockedObject[args Empty]");
        for (int i = 0; i < annotations.length; i++) {
            for (int j = 0; j < annotations[i].length; j++) {
                if (annotations[i][j] instanceof LockedObject) {
                    LockedObject lockedObject = (LockedObject) annotations[i][j];
                    Object arg = args[i];
                    return getLockObject(lockedObject,arg);
                }
            }
        }
        return null;
    }

    private Object getLockObject(LockedObject lockedObject, Object arg) {
        if (null == arg) return arg;
        Class<?> aClass = arg.getClass();
        if (null != lockedObject && StringUtility.hasLength(lockedObject.value())) {
            try {
                PropertyDescriptor propertyDescriptor;
                if(aClass.getName().equals("java.util.HashMap")){
                    Map dataMap = (Map)arg;
                    return dataMap.get(lockedObject.value());
                }else{
                    propertyDescriptor = EntityPropertyUtility.getPropertyDescriptor(aClass, lockedObject.value());
                }
                Method readMethod = propertyDescriptor.getReadMethod();
                return readMethod.invoke(arg);
            } catch (Exception e) {
                throw new RuntimeException("Can not find @LockedObject[Object Empty]");
            }
        } else if ((aClass == long.class) || (aClass == Long.class)) {
            return arg;
        } else if ((aClass == int.class) || (aClass == Integer.class)) {
            return arg;
        } else if ((aClass == char.class) || (aClass == Character.class)) {
            return arg;
        } else if ((aClass == short.class) || (aClass == Short.class)) {
            return arg;
        } else if ((aClass == double.class) || (aClass == Double.class)) {
            return arg;
        } else if ((aClass == float.class) || (aClass == Float.class)) {
            return arg;
        } else if ((aClass == boolean.class) || (aClass == Boolean.class)) {
            return arg;
        } else if (aClass == String.class) {
            return arg;
        } else if (aClass == java.sql.Date.class) {
            return arg;
        } else if (aClass == BigDecimal.class) {
            return arg;
        } else {
            return null;
        }
    }
}
