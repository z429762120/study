package com.tool.collect.skytools.concurrent;

import java.util.concurrent.DelayQueue;

/**
 *
 * @Descriiption 延迟队列 入队元素必须实现Delayed
 * 底层基于一个PriorityQueue实现，
 * @Author bo
 * @Date 2021/10/18 下午5:05
 **/
public class DelayQueueDemo {
	public static void main(String[] args) {
		DelayQueue queue = new DelayQueue();
		queue.put(1);
	}

}
