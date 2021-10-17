package com.tool.collect.skytools.redis;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @Descriiption 手写LRU算法
 * @Author bo
 * @Date 2021/10/9 上午9:44
 **/
public class LRUCache<K,V> extends LinkedHashMap<K,V> {
	private final int MAX_ENTRIES = 100;

	/**
	 * 构造函数指定了accessOrder=true，元素被访问后会移动到链表尾部，
	 * @param initialCapacity
	 */
	public LRUCache(int initialCapacity) {
		super(initialCapacity, 0.75f, true);
	}

	/**
	 * 当put或者putAll操作是，超过了链表的最大允许值，会移除链表最头部的元素（即使用频率最低的元素）
	 * @param eldest
	 * @return
	 */
	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > MAX_ENTRIES;
	}

	public static void main(String[] args) {
		LRUCache lruCache = new LRUCache(5);
		lruCache.put("a", "aa");
		lruCache.put("b", "bb");
		lruCache.put("c", "cc");
		lruCache.put("d", "dd");
		lruCache.get("c");
		lruCache.get("b");

		lruCache.forEach((k, v) -> System.out.println("k=" + k + " v=" + v));
	}
}
