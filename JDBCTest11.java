package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCTest11 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode?serverTimezone=Asia/Shanghai", "root", "root");
            String sql = "insert into t_user(id,username) values(?,?)";
            ps=connection.prepareStatement(sql);
            ps.setInt(1,50);
            ps.setString(2,"qqs");
            
            int count=ps.executeUpdate();
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    ps.close();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}