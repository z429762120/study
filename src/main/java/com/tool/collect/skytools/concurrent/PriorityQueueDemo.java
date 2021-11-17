package com.tool.collect.skytools.concurrent;

import java.util.PriorityQueue;

/**
 *
 * @Descriiption 基于数组实现的平衡二叉树 实现方式与PriorityBlockingQueue一致，线程不安全
 * @Author bo
 * @Date 2021/10/20 下午3:18
 **/
public class PriorityQueueDemo {
	public static void main(String[] args) {
		//如果不指定容量，默认11
		PriorityQueue queue = new PriorityQueue();
		queue.add(1);
		queue.poll();
	}
}
