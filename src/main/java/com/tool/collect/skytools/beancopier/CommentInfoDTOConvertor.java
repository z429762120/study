package com.tool.collect.skytools.beancopier;

import net.sf.cglib.core.Converter;

/**
 *
 * @Descriiption
 * @Author bo
 * @Date 2021/7/28 下午5:45
 **/
public class CommentInfoDTOConvertor implements Converter {
	/**
	 * 如果定义了Converter,那么所有属性都需要设置
	 * source属性如果是基础类型，会被转换为包装类型
	 * @param source 源属性值
	 * @param target 目标属性类型
	 * @param context 设置目标属性的方法
	 * @return
	 */
	@Override
	public Object convert(Object source, Class target, Object context) {
		if (source == null) {
			return null;
		}
		System.out.println(source.getClass());
		System.out.println(source.getClass().equals(target));

		return null;
	}
}
