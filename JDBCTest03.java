package com.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCTest03 {
    public static void main(String[] args) {
        ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
        String driver= bundle.getString("driver");
        String url= bundle.getString("url");
        String user= bundle.getString("user");
        String password = bundle.getString("password");

        Connection connection=null;
        Statement statement=null;
        try {
            //注册驱动

            Class.forName(driver);
            //创建连接
            /*String url="jdbc:mysql://127.0.0.1:3306/bjpowernode?serverTimezone=Asia/Shanghai";
            String user="root";
            String password="root";*/
            connection =DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接对象："+connection);
            //获取数据库操作对象
            statement =connection.createStatement();
            //执行sql
            String sql="insert into t_user(id,username) values (11,'wxw')";
            int count=statement.executeUpdate(sql);
            System.out.println(count==1?"保存成功":"保存失败");
        } catch (Exception throwables) {
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
