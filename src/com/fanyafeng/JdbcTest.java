package com.fanyafeng;

import java.sql.*;

/**
 * Created by fanyafeng on 16/8/2.
 */
public class JdbcTest {
    public static void main(String[] args) {
        //数据库连接
        Connection connection = null;
        //预编译的statement,使用预编译的statement提高数据库性能
        PreparedStatement preparedStatement = null;
        //结果集
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");//加载数据库驱动
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "root", "mysql");
            //定义sql语句,?为占位符
            String sql = "select * from user where username = ?";
            //获取预处理statement
            preparedStatement = connection.prepareStatement(sql);
            //设置参数,第一个参数为sql语句中参数的序号(从1开始),第二个参数为设置的参数值
            preparedStatement.setString(1, "樊亚风");
            //向数据库发出sql执行查询,查询出结果集
            resultSet = preparedStatement.executeQuery();
            //遍历所有结果集
            while (resultSet.next()) {
                System.out.println(resultSet.getString("id") + " | " + resultSet.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
