package com.tool.collect.skytools.zookeeper;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessSemaphoreV2;
import org.apache.curator.framework.recipes.locks.Lease;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/9/9 上午10:06
 **/
public class SemaphoreTest {
	public static void main(String[] args) throws Exception{
		RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
		CuratorFramework client = CuratorFrameworkFactory.newClient("192.168.56.103:2181,192.168.56.104:2181,192.168.56.105:2181", retryPolicy);
		client.start();


		//SharedCountReader countReader = new SharedCount(client, "/semaphore/semephore_01", 3);
		InterProcessSemaphoreV2 semaphoreV2 = new InterProcessSemaphoreV2(client, "/semaphore/semephore_01", 1);
		final Lease lease = semaphoreV2.acquire();
		System.out.println("获取到租约，do somethings");
		Thread.sleep(2000L);
		semaphoreV2.returnLease(lease);
		System.out.println("归还租约");
	}
}
