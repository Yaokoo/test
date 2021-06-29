package com.test;

import java.sql.*;
import java.util.Scanner;

public class TestMain1 {
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode?serverTimezone=Asia/Shanghai","root","root");
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        boolean flag=false;

        String sql1="insert into t_user (id,username) values (?,?)";
        String sql2="delete from t_user where id=?";
        String sql3="select * from t_user";
        String sql4="update t_user set username=? where id=?";
        String sql5="select * from login where username=? and password=?";
        System.out.println("请输入用户名");
        String LoginName=sc.next();
        System.out.println("请输入密码:");
        String LoginPwd=sc.next();

        ps=connection.prepareStatement(sql5);
        ps.setString(1,LoginName);
        ps.setString(2,LoginPwd);
        resultSet=ps.executeQuery();
        if (resultSet.next()){
            flag=true;
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
            close(resultSet,ps);
            if (connection != null) {
                connection.close();
            }
            return;
        }

        while (true){
            System.out.println("-----学生信息管理系统-----");
            System.out.println("-----1.添加信息-----");
            System.out.println("-----2.删除信息-----");
            System.out.println("-----3.查询信息-----");
            System.out.println("-----4.修改信息-----");
            System.out.print("请选择:");
            int select=sc.nextInt();

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
                close(null,ps);

            }else if(select==2){
                System.out.println("请输入删除的编号:");
                String id=sc.next();
                ps=connection.prepareStatement(sql2);
                ps.setString(1,id);
                int count=ps.executeUpdate();
                System.out.println(count==1?"删除成功":"删除失败");
                close(null,ps);
            }else if (select==3){
                ps=connection.prepareStatement(sql3);
                resultSet=ps.executeQuery();
                while (resultSet.next()){
                    String id=resultSet.getString("id");
                    String userName=resultSet.getString("username");
                    System.out.println(id+" "+userName);
                }
                close(resultSet,ps);
            }else if (select==4){
                System.out.println("请输入修改的编号:");
                String id=sc.next();
                System.out.println("请输入修改的姓名");
                String userName=sc.next();
                ps=connection.prepareStatement(sql4);
                ps.setString(1,userName);
                ps.setString(2,id);
                int count=ps.executeUpdate();
                System.out.println(count==1?"修改成功":"修改失败");
                close(null,ps);
            }
            System.out.println("退出系统请摁0，回到上级页面请摁任意键数字键");
            int quit=sc.nextInt();
            if (quit==0){
                System.out.println("系统正在退出");
                if (connection != null) {
                    connection.close();
                }
                System.out.println("谢谢使用");
                return;
            }
        }
    }

    private static void close(ResultSet resultSet, PreparedStatement ps) {
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
        }
    }
}
