package com.tool.collect.skytools.hystrix;

import java.util.concurrent.TimeUnit;

/**
 * @Descriiption
 * @Author bo
 * @Date 2021/4/6 下午5:29
 **/
public class MainTest {
    public static void main(String[] args) throws Exception {
        //circuitBreakerTest();
        //semaphoreMaxConcurrentTest();
        timeoutTest();
    }

    public static void timeoutTest() throws Exception {
        GetProductCommand command = new GetProductCommand(1L);
        command.execute();
    }

    /**
     * 断路器测试 一定时间内通过断路器流量达到20，且异常比例达到50%，之后的5秒钟，所有请求走降级
     * FIXME GetProductCommand的run方法修改为抛出异常
     */
    public static void circuitBreakerTest() throws Exception {
        for (int i = 0; i < 30; i++) {
            GetProductCommand command = new GetProductCommand((long) i);
            command.execute();
        }
        TimeUnit.SECONDS.sleep(3);

        for (int i = 31; i < 100; i++) {
            GetProductCommand command = new GetProductCommand((long) i);
            command.execute();
            System.out.println( "responseFromFallback: " + command.isResponseFromFallback() + ".isCircuitBreakerOpen:" + command.isCircuitBreakerOpen());
            TimeUnit.MILLISECONDS.sleep(500);
        }
    }


    /**
     * 测试信号量并发限制
     */
    public static void semaphoreMaxConcurrentTest() {
        //CyclicBarrier barrier = new CyclicBarrier(5);
        for (int i = 0; i < 5; i++) {
             Thread thread = new Thread(() -> {
                GetProductCommand command = new GetProductCommand(1L);
                try {
                   // barrier.wait();
                    System.out.println("线程：" + Thread.currentThread().getName() + " 开始执行");
                    command.execute();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            thread.start();
        }
    }

   // private static void semaphoreMaxConcurrentWorker()

   /* public static void main(String[] args) throws Exception {
        String[] productIds = new String[]{"1", "2","3"};
        com.tool.collect.skytools.hystrix.GetProductGroupCommand command = new com.tool.collect.skytools.hystrix.GetProductGroupCommand(productIds);
        final Observable<ProductInfo> observe = command.observe();
        observe.subscribe(new Observer<ProductInfo>() {
            @Override
            public void onCompleted() {
                System.out.println("全部请求完成。。。");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("出错啦"+throwable.getMessage());
            }

            @Override
            public void onNext(ProductInfo productInfo) {
                System.out.println("获取到产品" + productInfo);
            }

        });
    }*/
}
