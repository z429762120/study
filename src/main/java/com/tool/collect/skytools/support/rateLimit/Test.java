package com.tool.collect.skytools.support.rateLimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @Descriiption
 * @Author bo
 * @Date 2019/4/10 下午3:23
 **/
public class Test {
    public static void main(String[] args) {
        //
        RateLimiter limiter = RateLimiter.create(2);
        for (int i = 0; i < 10; i++) {
            if (limiter.tryAcquire(3,1L, TimeUnit.SECONDS)) {
                System.out.println("获取令牌成功：" + i);
            } else {

                System.out.println("获取令牌失败");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
