package com.tool.collect.skytools.mapper1;

import com.tool.collect.skytools.dto.TestLocalDate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Testlocaldate)表数据库访问层
 *
 * @author bo
 * @since 2020-12-09 13:53:23
 */
public interface TestlocaldateMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TestLocalDate queryById(@Param("id")Integer id);
    
     /**
     * 通过ID查询单条数据
     *
     * @param list id列表
     * @return 实例对象
     */
    List<TestLocalDate> queryByIds(List<Integer> list);

    /**
     * 通过实体作为筛选条件查询
     *
     * @param testlocaldate 实例对象
     * @return 对象列表
     */
    List<TestLocalDate> queryAll(TestLocalDate testlocaldate);

    /**
     * 新增数据
     *
     * @param testlocaldate 实例对象
     * @return 影响行数
     */
    int insert(TestLocalDate testlocaldate);

    /**
     * 新增数据
     *
     * @param list 实例对象列表
     * @return 影响行数
     */
    int insertBatch(List<TestLocalDate> list);

    /**
     * 修改数据
     *
     * @param param 参数
     * @param condition 条件
     * @return 影响行数
     */
    int updateNotNull(@Param("pr") TestLocalDate param, @Param("cd") TestLocalDate condition);

    /**
     * 修改数据
     *
     * @param testlocaldate 实例对象
     * @return 影响行数
     */
    int updateById(TestLocalDate testlocaldate);

    /**
     * 修改数据
     *
     * @param testlocaldate 实例对象
     * @return 影响行数
     */
    int updateNotNullById(TestLocalDate testlocaldate);


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@Param("id")Integer id);
    
    /**
     * 通过主键删除数据
     *
     * @param list id列表
     * @return 影响行数
     */
    int deleteByIds(List<Integer> list);

    Integer count(TestLocalDate testlocaldate);

}