package com.tool.collect.skytools.redis;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RSemaphore;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/2 下午1:55
 **/
public class RedissonSemaphoreTest {
	public static void main(String[] args) throws Exception {
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
		final RSemaphore semaphore = redisson.getSemaphore("semaphore1");
		semaphore.trySetPermits(3);

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("线程【"+Thread.currentThread().getName()+"】尝试获取锁");
					try {
						final boolean b = semaphore.tryAcquire(1,3, TimeUnit.SECONDS);
						if (b) {
							System.out.println(LocalDateTime.now() +"线程【"+Thread.currentThread().getName()+"】获取锁成功，开始执行任务");
							try {
								Thread.sleep(2000L);
							}
							catch (InterruptedException e) {
								e.printStackTrace();
							}
							semaphore.release();
							System.out.println(LocalDateTime.now()+"线程【"+Thread.currentThread().getName()+"】任务执行完成，释放锁");
						}

					}
					catch (InterruptedException e) {
						e.printStackTrace();
					}


				}
			}).start();

		}

	}
}
