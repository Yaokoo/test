package com.jdbc;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ResourceBundle;

public class JDBCTest06 {
    public static void main(String[] args) {
        ResourceBundle bundle=ResourceBundle.getBundle("jdbc");

        String driver=bundle.getString("driver");
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String password=bundle.getString("password");

        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try {
            Class.forName(driver);
            connection=DriverManager.getConnection(url,user,password);
            System.out.println("数据库连接对象"+connection);
            statement=connection.createStatement();
            String sql="select * from  t_user where id between 1 and 6";
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
