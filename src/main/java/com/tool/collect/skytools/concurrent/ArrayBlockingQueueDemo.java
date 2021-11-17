package com.tool.collect.skytools.concurrent;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @Descriiption 有界阻塞队列，基于数组+一把lock实现
 * @Author bo
 * @Date 2021/10/18 上午9:44
 **/
public class ArrayBlockingQueueDemo {
	public static void main(String[] args) throws Exception {
		//默认非公平策略 基于数组实现的有界阻塞队列，底层依靠一把锁ReentrantLock实现
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10 );
		//入队 阻塞直到成功
		queue.put(1);
		//入队，非阻塞，成功=true,失败=false
		final boolean offer = queue.offer(1);
		//出队，阻塞直到获取到值
		final Integer take = queue.take();
		//出队、非阻塞，如果队列没有元素返回null
		final Integer poll = queue.poll();
		//不出队，非阻塞返回队列头部元素
		final Integer peek = queue.peek();

		queue.size();
		queue.iterator();

	}
}
