package com.tool.collect.skytools.redis;

import org.redisson.Redisson;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/6 下午4:08
 **/
public class RedissonCountDownLatch {
	public static void main(String[] args) throws Exception{
		Config config = new Config();
		config.useClusterServers()
				//可以用"rediss://"来启用SSL连接
				.addNodeAddress("redis://192.168.56.103:7001")
				.addNodeAddress("redis://192.168.56.103:7002")
				.addNodeAddress("redis://192.168.56.103:7003")
				.addNodeAddress("redis://192.168.56.103:7004")
				.addNodeAddress("redis://192.168.56.103:7005")
				.addNodeAddress("redis://192.168.56.103:7006");
		RedissonClient redisson = Redisson.create(config);
		final RCountDownLatch countDownLatch = redisson.getCountDownLatch("anyCountDownLatch");
		if (countDownLatch.trySetCount(3)) {
			System.out.println("初始化countDownLatch必须达到3个线程，才能之后后续流程");

			for (int i = 0; i < 4; i++) {
				new Thread(new Runnable() {
					@Override
					public void run() {
						System.out.println("线程【"+Thread.currentThread().getName()+"】准备中。。。");
						countDownLatch.countDown();
						try {
							Thread.sleep(1000L);
							System.out.println("线程【"+Thread.currentThread().getName()+"】准备完毕，可以之后后续工作");
						}
						catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}).start();
			}
			Thread.sleep(4000L);
			countDownLatch.await();
			System.out.println("3个线程都已准备完毕，可以执行后续工作");
		}

	}
}
