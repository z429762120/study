package com.tool.collect.skytools.redis;


import com.tool.collect.skytools.support.constant.ErrorCode;
import com.tool.collect.skytools.support.exception.EXPF;
import org.springframework.data.redis.cache.DefaultRedisCachePrefix;
import org.springframework.data.redis.cache.RedisCacheKey;
import org.springframework.data.redis.cache.RedisCachePrefix;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Random;

/**
 * Redis锁
 *
 * @author Gnoll
 * @create 2017-08-04 11:01
 **/
public class RedisLock implements Serializable {

    private static final long MILLI_NANO_TIME = 1000 * 1000L;
    private static final int LOCKED = 1;
    private static final Random RANDOM = new Random();
    private static final RedisCachePrefix cachePrefix = new DefaultRedisCachePrefix();

    private RedisTemplate redisTemplate;

    public RedisLock(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 加锁
     *
     * @param timeOut 取锁超时时间
     * @param expire  锁自动过期时间
     */
    public Boolean lock(RedisCacheKey cacheKey, long timeOut, long expire) throws Exception {
        try {
            Object execute = redisTemplate.execute((RedisCallback<Boolean>) connection -> {
                long nanoTime = System.nanoTime();
                long lockTimeOut = timeOut * MILLI_NANO_TIME;
                try {
                    while (System.nanoTime() - nanoTime < lockTimeOut) {
                        if (connection.setNX(cacheKey.getKeyBytes(), redisTemplate.getValueSerializer().serialize(LOCKED))) {
                            connection.expire(cacheKey.getKeyBytes(), expire);
                            return true;
                        }
                        Thread.sleep(3, RANDOM.nextInt(30));
                    }
                    return false;
                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage(), EXPF.exception(ErrorCode.CacheLockError, true));
                }
            });
            return (Boolean) execute;
        } catch (Exception e) {
            throw (Exception) e.getCause();
        }
    }

    public void unlock(RedisCacheKey cacheKey) {
        redisTemplate.execute(connection -> {
            connection.del(cacheKey.getKeyBytes());
            return null;
        }, true);
    }

    public RedisCacheKey madeCacheKey(String prefix, Object key) {
        return new RedisCacheKey(key).usePrefix(cachePrefix.prefix(prefix)).withKeySerializer(redisTemplate.getKeySerializer());
    }
}
