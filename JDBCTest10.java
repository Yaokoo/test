package com.jdbc;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class JDBCTest10 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("请输入（desc或asc，desc表示升序，asc表示降序）:");
        String key=sc.nextLine();

        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bjpowernode?serverTimezone=Asia/Shanghai","root","root");

            statement=connection.createStatement();
            String sql="select ename from emp order by ename " + key;
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString("ename"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }if (statement != null) {
                try {
                    statement.close();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }if (connection != null) {
                try {
                    connection.close();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
        }
    }
}
