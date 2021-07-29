package com.tool.collect.skytools.wrapTempObject;

import java.time.LocalDate;
import java.util.Date;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.apache.commons.lang3.tuple.Triple;

/**
 *
 * @Descriiption 包装临时对象
 * @Author bo
 * @Date 2021/7/20 下午2:07
 **/
public class Test {
	public static void main(String[] args) throws Exception {
		/**包装两个对象，通过left、right获取*/
		//Pair<Integer,String> pair1 = Pair.of(11, "nihao");
		ImmutablePair pair = ImmutablePair.of(LocalDate.now(), "hello");
		System.out.println(pair.getKey());
		System.out.println(pair.getValue());

		MutablePair<Date,String> mutablePair = new MutablePair<>();
		mutablePair.setLeft(new Date());
		mutablePair.setRight("123");
		System.out.println(mutablePair.left);
		System.out.println(mutablePair.right);


		/**包装三个对象，通过left、middle,right获取*/
		Triple<String, Date, Integer> triple = Triple.of("nihao", new Date(), 111);
		System.out.println(triple.getLeft());
		System.out.println(triple.getMiddle());
		System.out.println(triple.getRight());

		MutableTriple mutableTriple = new MutableTriple();

	}
}
