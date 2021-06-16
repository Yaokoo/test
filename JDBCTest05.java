package com.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class JDBCTest05 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode?serverTimezone=Asia/Shanghai","root","root");
            System.out.println("数据库连接对象"+connection);
            statement=connection.createStatement();
            String sql="select * from t_user";
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String username=resultSet.getString("username");
                System.out.println(id+","+username);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
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
