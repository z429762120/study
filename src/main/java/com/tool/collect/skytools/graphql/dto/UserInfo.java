package com.tool.collect.skytools.graphql.dto;

import lombok.Data;

import java.util.List;

/**
 * Description: 登录用户展示信息
 * User: Tong zhao
 * Mail: yao928460050@163.com
 * Date: 2019-01-10
 */
@Data
public class UserInfo  {
    /** 组织名称 */
    private String organizationName;

    /**
     * 组织联系人名称
     */
    private String organizationContactName;

    /** 组织联系电话 */
    private String organizationPhone;

    /**
     * 组织注册地址（拼接省市区）
     */
    private String organizationAddress;
    /**
     * 组织注册地址（未拼接省市区）
     */
    private String detailAddress;

    /** 组织类型 */
    private Integer organizationType;

    /** 组织区域 */
    private Integer organizationAreaCode;

    /** 兼容终端网id */
    @Deprecated
    private Integer ecommerceId;

    /** 个人名称 */
    private String personName;

    /** 个人手机号 */
    private String personPhone;

    /** 个人标识 */
    private String personId;

    /**
     * 当前组织标识
     */
    private String organizationId;

    /**
     * 当前组织下的角色
     */
    private List<String> roleIdlist;

    private List<Dog> dogs;

}
