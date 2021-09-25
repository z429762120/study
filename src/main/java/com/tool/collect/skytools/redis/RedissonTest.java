package com.tool.collect.skytools.redis;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/2 下午1:55
 **/
public class RedissonTest {
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
		final RLock fairLock = redisson.getFairLock("mylock");
		//fairLock.lock(, );

		final RReadWriteLock readWriteLock = redisson.getReadWriteLock("mylock1");
		final RLock readLock = readWriteLock.readLock();
		readLock.lock();

		System.out.println("获得锁");
		//Thread.sleep(33000L);
		readLock.unlock();
		System.out.println("释放锁");

	}
}
