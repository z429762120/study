package com.tool.collect.skytools.beancopier;

import java.util.Arrays;
import java.util.Date;

import com.alibaba.fastjson.JSON;
import com.tool.collect.skytools.dto.Person;

import org.springframework.beans.BeanUtils;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/7/28 下午4:31
 **/
public class beanCopierTest {

	public static void main(String[] args) throws Exception {
		CommentInfoDO commentInfoDO = new CommentInfoDO();
		commentInfoDO.setUsername("zhangsan");
		commentInfoDO.setCommentContent("hello");
		commentInfoDO.setCommentStatus(1);
		commentInfoDO.setDefaultComment(21);
		commentInfoDO.setGmtCreate(new Date());
		commentInfoDO.setGoodsId(11L);
		commentInfoDO.setPersonList(Arrays.asList(new Person("亦凡", 12)));

		//springBeanCopy(commentInfoDO, CommentInfoDTO.class);
		cglibBeanCopy(commentInfoDO, CommentInfoDTO.class);
	}

	private static <T> void springBeanCopy(CommentInfoDO commentInfoDO,Class<T> clazz) throws Exception {
		final T t = clazz.newInstance();
		BeanUtils.copyProperties(commentInfoDO, t);
		System.out.println(JSON.toJSONString(t));
	}

	private static <T> void cglibBeanCopy(CommentInfoDO commentInfoDO,Class<T> clazz) throws Exception {
		final T t = clazz.newInstance();
		//BeanCopierUtils.copyProperties(commentInfoDO, t,new CommentInfoDTOConvertor());
		BeanCopierUtils.copyProperties(commentInfoDO, t);
		System.out.println(commentInfoDO);
		System.out.println(t);


	}


}
