package com.tool.collect.skytools.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/10/15 上午9:42
 **/
public class ConcurrentLinkedQueueDemo {

	public static void main(String[] args) {
		ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();
		//入队，基于CAS将元素添加到队列尾部
		final boolean offer = queue.offer(11);
		//出队，返回队列头部元素
		final Integer poll = queue.poll();
		//不出队，返回队列头部元素
		final Integer peek = queue.peek();
		//是否包含某个元素，不保证数据一致性
		final boolean contains = queue.contains(11);


	}
}
