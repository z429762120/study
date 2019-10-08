package com.tool.collect.skytools.support.rateLimit;


import com.google.common.util.concurrent.RateLimiter;
import com.tool.collect.skytools.support.constant.ErrorCode;
import com.tool.collect.skytools.support.exception.EXPF;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.hibernate.validator.internal.util.logging.Log;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;


/**
 * 方法限流切面
 *
 * @author yangran
 * @create 2017/8/18
 */
@Aspect
@Order(5)  // 执行顺序
@Component
public class RateLimiterAspect {

    protected static final Log log = LoggerFactory.make();
    private final ConcurrentHashMap<String, RateLimiter> limiters;
    private final KeyFactory keyFactory;

    @Autowired
    public RateLimiterAspect(Optional<KeyFactory> keyFactory) {
        this.limiters = new ConcurrentHashMap<>();
        this.keyFactory = (jp, limit) -> JoinPointToStringHelper.toString(jp, limit);
    }

    @Before("@annotation(limit)")
    public void rateLimite(JoinPoint jp, Limiter limit) throws Throwable {
        String key = createKey(jp, limit);
        RateLimiter limiter = limiters.computeIfAbsent(key, createLimiter(jp, limit));
        if (limiter != null) {
            if (limiter.tryAcquire()) {
                log.info(">>>>>>>>>>>>>>获取令牌成功");
            }else {
                log.error(">>>>>>>>>>>>>>请求太频繁，获取令牌失败");
                throw EXPF.exception(ErrorCode.RateLimiter,true);
            }
        }
    }

    private Function<String, RateLimiter> createLimiter(JoinPoint jp, Limiter limit) {
        String keyProps = limit.value();
        if (StringUtils.isEmpty(keyProps)) {
            keyProps = getKeyProps(jp);
        }
        //如果没有配置这个值 就设置为无限大
        int limitVal = limit.count();
        try {
            double limitDoubleVal = Double.valueOf(limitVal);
            return name -> RateLimiter.create(limitDoubleVal);
        } catch (NumberFormatException e) {
            log.error("限流属性转换异常.... key : " + keyProps);
            return name -> RateLimiter.create(Double.MAX_VALUE);
        }

    }

    private String createKey(JoinPoint jp, Limiter limit) {
        return keyFactory.createKey(jp, limit);
    }

    @FunctionalInterface
    public interface KeyFactory {
        String createKey(JoinPoint jp, Limiter limit);
    }

    public String getKeyProps(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        String className = jp.getTarget().getClass().getName();
        return className.concat(".").concat(methodName).concat("limit");
    }

}
