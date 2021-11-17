package com.tool.collect.skytools.concurrent;

import java.util.concurrent.PriorityBlockingQueue;

import org.apache.commons.lang3.RandomUtils;

/**
 * 无界队列 优先阻塞队列 线程安全
 * @Descriiption 优先队列，基于数组实现的平衡二叉树，保证队列头部的元素一定是优先级最高的
 * 每次take/poll的时候，会将优先级最高的元素移动队列头部
 * @Author bo
 * @Date 2021/10/18 下午3:55
 **/
public class PriorityBlockingQueueDemo {
	public static void main(String[] args) throws Exception{
		//如果不指定capacity,则初始化capacity=11
		//扩容时  如果数组长度<64 ,每次扩容capacity = capacity+(capacity+2)
		//       如果数组长度>=64 ,每次扩容capacity = capacity+capacity>>1
		PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(5);
		for (int i = 0; i < 20; i++) {
			final int randomNum = RandomUtils.nextInt(0, 100);
			System.out.println("第" + i + "次循环，随机值为：" + randomNum);
			queue.put(randomNum);
		}
		for (int i = 0; i < 10; i++) {
			queue.take();
		}

	}
}
