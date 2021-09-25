package com.tool.collect.skytools.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 *
 * @Descriiption 互斥锁
 * @Author bo
 * @Date 2021/9/9 上午10:06
 **/
public class InterProcessSemaphoreMutexTest {
	public static void main(String[] args) throws Exception{
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.56.103:2181,192.168.56.104:2181,192.168.56.105:2181", retryPolicy);
		client.start();


		final InterProcessSemaphoreMutex semaphoreMutex = new InterProcessSemaphoreMutex(client, "/semaphore/semephore_01");
		semaphoreMutex.acquire();
		System.out.println("获取到租约，do somethings");
		Thread.sleep(2000L);
		semaphoreMutex.release();
		System.out.println("归还租约");
	}
}
