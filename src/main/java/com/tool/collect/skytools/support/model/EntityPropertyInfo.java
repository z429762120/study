package com.tool.collect.skytools.support.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.beans.PropertyDescriptor;

/**
 * Entity对象属性信息类
 *
 * @author Gnoll
 * @create 2017-04-14 12:19
 **/
@Data
@AllArgsConstructor
public class EntityPropertyInfo {
    private PropertyDescriptor primaryKey;
    private PropertyDescriptor[] otherKey;
}
