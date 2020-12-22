package com.tool.collect.skytools.test;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Descriiption
 * @Author bo
 * @Date 2020/12/9 上午11:42
 **/
public class MysqlTest {
    public static void main(String[] args) {

        Connection conn = null ;
        List list = new ArrayList();
        try{
            //加载JDBC驱动程序：
            Class.forName("com.mysql.jdbc.Driver");
            // 问号后面是解决中文乱码输入问题,UTC是统一标准世界时间
            String url = "jdbc:mysql://47.106.87.193:3306/liubo?useUnicode=true&characterEncoding=utf-8";
            String username = "case";
            String password = "Lh19890624.";
            // 创建与MySQL数据库的连接类的实例
            conn = DriverManager.getConnection(url, username, password);
            // 用conn创建Statement对象类实例
            conn.setAutoCommit(true);
            Statement sql_statement = conn.createStatement();

            // sql拼装
		    String sql = " insert into testLocalDate (id,time) values (1,\'"+ LocalDateTime.now() +"\') " ;
            // 执行sql
            final boolean execute = sql_statement.execute(sql);
//		    int num = sql_statement.executeUpdate(sql);
//		    System.out.println("返回结果："+num);
            //处理结果
            /*int column = result!=null? result.getMetaData().getColumnCount() : 0;
            // 一行数据
            while (result.next()) {
                // 对象数组，表示一行数据
                Map map = new HashMap();

                for (int i = 1; i <= column; i++) {
                    // 获得列名
                    String columnName = result.getMetaData().getColumnName(i);
                    map.put(columnName, result.getObject(columnName));
                }
                list.add(map);
            }*/

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (conn != null) {
                // 关闭连接
                try {
                    conn.close();
                }
                catch (Exception e) {
                    System.out.println("连接关闭异常");
                }
            }
        }
        System.out.println(list);
    }


}
