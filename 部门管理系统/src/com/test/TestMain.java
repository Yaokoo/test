package com.test;

import java.sql.*;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode?serverTimezone=Asia/Shanghai","root","root");
        PreparedStatement ps=null;
        ResultSet resultSet=null;

        System.out.println("-----学生信息管理系统-----");
        System.out.println("-----1.添加信息-----");
        System.out.println("-----2.删除信息-----");
        System.out.println("-----3.查询信息-----");
        System.out.println("-----4.修改信息-----");
        System.out.print("请选择:");
        int select=sc.nextInt();

        String sql1="insert into t_user (id,username) values (?,?)";
        String sql2="delete from t_user where id=?";
        String sql3="select * from t_user";
        if (select==1){
            System.out.println("请输入添加的编号:");
            String id=sc.next();
            System.out.println("请输入添加的姓名");
            String userName=sc.next(); //使用nextline会出现跳过问题


            ps=connection.prepareStatement(sql1);
            ps.setString(1,id);
            ps.setString(2,userName);
            int count=ps.executeUpdate();
            System.out.println(count==1?"添加成功":"添加失败");
            close(null,ps,connection);

        }else if(select==2){
            /*System.out.println("请输入删除的编号");
            String id=sc.next();*/
            System.out.println("请输入删除的编号:");
            String id=sc.next();

            ps=connection.prepareStatement(sql2);
            ps.setString(1,id);
            int count=ps.executeUpdate(sql2);
            System.out.println(count==1?"删除成功":"删除失败");
            close(null,ps,connection);
        }
    }

    private static void close(ResultSet resultSet, PreparedStatement ps, Connection connection) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }if (ps != null) {
            try {
                ps.close();
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
