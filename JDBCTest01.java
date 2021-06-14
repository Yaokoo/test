package com.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest01 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            //注册驱动
            DriverManager.registerDriver(new Driver());
            //创建连接
            String url="jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user="root";
            String password="root";
            connection =DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接对象："+connection);
            //获取数据库操作对象
            statement =connection.createStatement();
            //执行sql
            String sql="insert into t_user(id,username) values (8,'feige')";
            int count=statement.executeUpdate(sql);
            System.out.println(count==1?"保存成功":"保存失败");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //释放资源
            if ( statement!= null) {
                try {
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
