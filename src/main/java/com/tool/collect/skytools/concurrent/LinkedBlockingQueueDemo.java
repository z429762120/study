package com.tool.collect.skytools.concurrent;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * 有界阻塞队列 基于单项量表+两把锁实现 takeLock\putLock
 * @Descriiption
 * @Author bo
 * @Date 2021/10/17 下午3:27
 **/
public class LinkedBlockingQueueDemo {
	public static void main(String[] args) throws Exception {
		LinkedBlockingQueue queue = new LinkedBlockingQueue();
		//入队，元素添加到队列尾部  队列满了则阻塞
		queue.put(1);
		//入队，非阻塞，成功返回true,失败返回false
		queue.offer(1);
		//出队，队列空则阻塞
		queue.take();
		//出队，非阻塞，队列为空返回null
		queue.poll();
		//获取队列头部元素，不出队
		queue.peek();
		//基于AtomicInteger记录的队列元素个数
		queue.size();
		queue.iterator();
	}
}
