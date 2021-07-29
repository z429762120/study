package com.tool.collect.skytools.beancopier;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @Descriiption bean 复制类 效率比spring BeanUtils更高
 *
 * @Author bo
 * @Date 2021/7/28 下午4:32
 **/
public class BeanCopierUtils {
	private static Logger logger = LoggerFactory.getLogger(BeanCopierUtils.class);

	private static Map<String, BeanCopier> beanCopierCacheMap = new ConcurrentHashMap<>();

	public static void copyProperties(Object source, Object target) {
		copyProperties(source, target, null);
	}

	public static void copyProperties(Object source, Object target, Converter converter) {
		BeanCopier beanCopier;
		final String key = source.getClass().toString() + target.getClass().toString();
		if (!beanCopierCacheMap.containsKey(key)) {
			beanCopier = BeanCopier.create(source.getClass(), target.getClass(), null != converter);
			beanCopierCacheMap.put(key, beanCopier);
		}
		else {
			beanCopier = beanCopierCacheMap.get(key);
		}
		//beanCopier只能复制类型、名字相同的属性,如果是范型集合，目标集合的范型类型会被改变
		beanCopier.copy(source, target, converter);
		copyListProperties(source, target);
	}

	private static void copyListProperties(Object source, Object target) {
		final Class<?> targetClass = target.getClass();
		final Field[] targetFields = targetClass.getDeclaredFields();
		for (Field targetField : targetFields) {
			if (targetField.getType() != List.class) {
				continue;
			}
			Object sourceFiledValue = getFieldValue(targetField.getName(), source);
			if (sourceFiledValue == null) {
				continue;
			}
			List<?> list = (List<?>) sourceFiledValue;
			if (list.size() == 0) {
				continue;
			}
			final Class<?> genericType = getFieldGenericType(targetField);
			if (genericType == null) {
				continue;
			}
			List list1 = new ArrayList(list.size());
			try {
				for (Object o : list) {
					final Object o1 = genericType.newInstance();
					copyProperties(o, o1);
					list1.add(o1);
				}
			}
			catch (InstantiationException | IllegalAccessException e) {
				logger.info("复制对象属性异常，实例化目标对象【{}】失败，errorMsg=【{}】", genericType, e.getMessage());
			}
			try {
				targetField.setAccessible(true);
				targetField.set(target, list1);
			}
			catch (IllegalAccessException e) {
				logger.info("复制对象属性异常，class 【{}】 field 【{}】 无访问权限", targetClass, targetField.getName());
			}
		}
	}

	private static Class<?> getFieldGenericType(Field field) {
		final Type genericType = field.getGenericType();
		if (genericType instanceof ParameterizedType) {
			final ParameterizedType parameterizedType = (ParameterizedType) genericType;
			return (Class<?>) parameterizedType.getActualTypeArguments()[0];
		}
		return null;
	}

	private static Object getFieldValue(String fieldName, Object object) {
		try {
			final Field field = object.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(object);
		}
		catch (NoSuchFieldException | IllegalAccessException e) {
			return null;
		}
	}

}
