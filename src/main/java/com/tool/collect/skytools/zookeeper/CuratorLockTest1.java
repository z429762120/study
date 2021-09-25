package com.tool.collect.skytools.zookeeper;

import java.util.Arrays;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMultiLock;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/8 下午2:49
 **/
public class CuratorLockTest1 {
	public static void main(String[] args) throws Exception{
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.56.103:2181,192.168.56.104:2181,192.168.56.105:2181", retryPolicy);
		client.start();

		InterProcessMutex lock1 = new InterProcessMutex(client, "/my/path1");
		InterProcessMutex lock2 = new InterProcessMutex(client, "/my/path2");
		InterProcessMultiLock multiLock = new InterProcessMultiLock( Arrays.asList(lock1, lock2));
		multiLock.acquire();
		System.out.println("test1获得锁，do something");

		//Thread.sleep(1000L);
		multiLock.release();
		System.out.println("test1释放锁");


		/*if (lock.acquire(1, TimeUnit.SECONDS)) {
		}*/

	}
}
