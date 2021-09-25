package com.tool.collect.skytools.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 *
 * @Descriiption 可重入锁
 * @Author bo
 * @Date 2021/9/8 下午2:49
 **/
public class CuratorLockTest {
	public static void main(String[] args) throws Exception{
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.56.103:2181,192.168.56.104:2181,192.168.56.105:2181", retryPolicy);
		client.start();

		//final String path = client.create().creatingParentContainersIfNeeded().forPath("/my/path", "hello world".getBytes());
		//client.delete().forPath("/my/path");

		InterProcessLock lock = new InterProcessMutex(client, "/my/path1");
		lock.acquire();
		System.out.println("test获得锁，do something");

		Thread.sleep(20000L);
		lock.release();
		System.out.println("test释放锁");


		/*if (lock.acquire(1, TimeUnit.SECONDS)) {
		}*/

	}
}
