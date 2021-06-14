package com.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest02 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            DriverManager.registerDriver(new Driver());
            String url="jdbc:mysql://127.0.0.1:3306/bjpowernode";
            String user="root";
            String password="root";
            connection=DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接对象"+connection);
            statement=connection.createStatement();

           String sql="delete from t_user where id=6";
            int count=statement.executeUpdate(sql);
            System.out.println(count==1?"删除成功":"删除失败");

            //DriverManager.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (statement != null) {
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
