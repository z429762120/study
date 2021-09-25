package com.tool.collect.skytools.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 *
 * @Descriiption 可重入锁
 * @Author bo
 * @Date 2021/9/8 下午2:49
 **/
public class ReadWriteLockTest {
	public static void main(String[] args) throws Exception{
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.56.103:2181,192.168.56.104:2181,192.168.56.105:2181", retryPolicy);
		client.start();

		InterProcessReadWriteLock lock = new InterProcessReadWriteLock(client, "/my/path1");
		final InterProcessMutex readLock = lock.readLock();
		final InterProcessMutex writeLock = lock.writeLock();
		readLock.acquire();
		System.out.println("读锁加锁成功");

		readLock.release();
		System.out.println("读锁释放成功");

		writeLock.acquire();
		System.out.println("写锁加锁成功");

		writeLock.release();
		System.out.println("写锁释放成功");



	}
}
