package com.tool.collect.skytools.beancopier;

import net.sf.cglib.core.Converter;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/7/28 下午5:45
 **/
public class CommentInfoDTOConvertor implements Converter {
	@Override
	public Object convert(Object source, Class target, Object context) {
		System.out.println(source);
		System.out.println(target);
		System.out.println(context);

		return null;
	}
}
