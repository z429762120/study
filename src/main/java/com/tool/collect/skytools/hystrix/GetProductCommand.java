package com.tool.collect.skytools.hystrix;

import com.netflix.hystrix.*;

/**
 * @Descriiption 获取单条数据 默认同步执行
 * @Author bo
 * @Date 2021/4/6 下午5:18
 **/
public class GetProductCommand extends HystrixCommand<ProductInfo> {
    private Long productId;

    public GetProductCommand(Long productId) {
        super(Setter
                //每个command可以设置自己的组，会通过 command group 来聚合一些监控和报警信息，默认情况下同一个 command group 中的请求，都会进入同一个线程池中
                //代表某一个依赖服务，例如商品服务
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey(GetProductCommand.class.getName()))
                // 代表一类commond,比如一个接口
                .andCommandKey(HystrixCommandKey.Factory.asKey("GetProductCommand"))
                // 代表一个线程池， 默认情况是commandGroup的名称，如果command想要用自己的线程池，可以自定义名字
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("GetProductCommandPool"))
                /**线程池的一些设置*/
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                        //线程池大小 默认10
                        .withCoreSize(10)
                        //设置线程池的最大值，只有在设置了allowMaximumSizeToDivergeFromCoreSize时才生效
                        .withMaximumSize(10)
                        .withAllowMaximumSizeToDivergeFromCoreSize(true)
                        // 当线程池中的线程空闲超过该时间后，就会被销毁，单位分钟，默认1
                        .withKeepAliveTimeMinutes(1)
                        //线程池满了之后，再有请求会压入队列，指定队列大小，默认不限
                        //.withMaxQueueSize(1000)
                        //队列满了之后reject的阈值，通过此参数控制线程的最大大小，默认10，与MaxQueueSize配合使用，取较小值
                        .withQueueSizeRejectionThreshold(10)
                )
                /**command的一些设置*/
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        //资源隔离策略 SEMAPHORE（信号量）、THREAD（线程池、默认）
                        //线程池机制，每个 command 运行在一个线程中，限流是通过线程池的大小来控制的；
                        //信号量机制，command 是运行在调用线程中，通过信号量的容量来进行限流，常见于那种基于纯内存的一些业务逻辑服务，而不涉及到任何网络访问请求
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                        //使用 SEMAPHORE 隔离策略的时候允许访问的最大并发量，超过这个最大并发量，请求直接被 reject,默认10
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(3)
                        /** 断路器相关配置 一定时间(默认10s)内通过断路器流量达到20，且异常比例达到50%，之后的5秒钟，所有请求走降级*/
                        //控制是否允许断路器工作，包括跟踪依赖服务调用的健康状况，以及对异常情况过多时是否允许触发断路。默认值是 true。
                        .withCircuitBreakerEnabled(true)
                        //经过断路器的流量超过了一定的阈值，才有可能触发断路,默认20
                        .withCircuitBreakerRequestVolumeThreshold(20)
                        //表示异常比例达到多少，才会触发断路，默认值是 50(%)
                        .withCircuitBreakerErrorThresholdPercentage(30)
                        //断路后多少时间内直接reject请求，走fallback降级逻辑，之后进入half-open状态，默认5000ms
                        .withCircuitBreakerSleepWindowInMilliseconds(2000)
                        /**超时的相关设置，如果false则不开启，达到超时时间直接降级，不会管真实逻辑的返回值*/
                        //是否开启超时降级机制，默认开启（true）
                        .withExecutionTimeoutEnabled(true)
                        //开启超时降级机制后，允许的最大超时时间，默认1s
                        .withExecutionTimeoutInMilliseconds(1000)
                        //强制开启断路器，默认false，相当于手动降级
                        .withCircuitBreakerForceOpen(false)
                        /**
                         * 统计相关
                         */
                        //设置统计 滑动窗口的时间，单位毫秒，默认10000，即10s，hystrix会维持这段时间内的metric供断路器使用
                        .withMetricsRollingStatisticalWindowInMilliseconds(10000)
                        //每个滑动窗口被拆分为多少个bucket,默认10个，也就是每秒钟1个bucket，滑动窗口统计时间必须对这个参数能够整除
                        .withMetricsRollingStatisticalWindowBuckets(10)
                        //控制是否追踪请求耗时，以及通过百分比方式来统计，默认是 true
                        .withMetricsRollingPercentileEnabled(true)
                        //滑动窗口 被持久化保存的时间，这样才能计算一些请求耗时的百分比，默认是 60000 = 60s
                        .withMetricsRollingPercentileWindowInMilliseconds(60000)
                        //设置 rolling percentile window 被拆分成的 bucket 数量，上面那个参数除以这个参数必须能够整除，不允许热修改
                        //默认值是 6，也就是每 10s 被拆分成一个 bucket
                        .withMetricsRollingPercentileWindowBuckets(6)
                        //设置每个 bucket 的请求执行次数被保存的最大数量，如果在一个 bucket 内，执行次数超过了这个值，那么就会重新覆盖从 bucket 的开始再写
                        //举例来说，如果 bucket size 设置为 100，而且每个 bucket 代表一个 10 秒钟的窗口， 但是在这个 bucket 内发生了 500 次请求执行，那么这个 bucket 内仅仅会保留 100 次执行
                        .withMetricsRollingPercentileBucketSize(100)
                        //控制成功和失败的百分比计算，与影响短路器之间的等待时间，默认值是 500 毫秒
                        .withMetricsHealthSnapshotIntervalInMilliseconds(500)

                )
        );

        this.productId = productId;
    }

    @Override
    protected ProductInfo run() throws Exception {
        Thread.sleep(1200);
        System.out.println("商品productId="+productId);
        /*if (productId < 30) {
            throw new Exception();
        }*/
        final ProductInfo info = new ProductInfo(productId, "花生");
        System.out.println(info);
        return info;
    }


    /**
     * Hystrix 出现以下四种情况，都会去调用 fallback 降级机制：
     *
     * 断路器处于打开的状态。
     * 资源池已满（线程池+队列 / 信号量）。
     * Hystrix 调用各种接口，或者访问外部依赖，比如 MySQL、Redis、Zookeeper、Kafka 等等，出现了任何异常的情况。
     * 访问外部依赖的时候，访问时间过长，报了 TimeoutException 异常。
     * @return
     */
    @Override
    protected ProductInfo getFallback() {
        System.out.println("降级商品,productId="+productId);
        return new ProductInfo(404L,"商品不存在");
    }



}
