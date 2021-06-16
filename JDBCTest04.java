package com.jdbc;

import java.sql.*;

public class JDBCTest04 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode?serverTimezone=Asia/Shanghai","root","root");
            System.out.println("数据库连接对象"+connection);
            statement=connection.createStatement();
            String sql="select * from t_user";
            rs=statement.executeQuery(sql);
            while (rs.next()){
                int id=rs.getInt("id");
                String username=rs.getString("username");
                System.out.println(id+","+username);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
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
