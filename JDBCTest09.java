package com.jdbc;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;

public class JDBCTest09 {
    public static void main(String[] args) {
        //登录页面
        Map<String,String> userLoginInfo =initui();
        //判断
        Boolean LoginSuccess=Login(userLoginInfo );

        System.out.println(LoginSuccess?"登陆成功":"登陆失败");
    }

    /**
     *
     * @param userLoginInfo 用户登录信息
     * @return false表示失败 ture表示成功
     */
    private static Boolean Login(Map<String, String> userLoginInfo) {
        ResourceBundle bundle=ResourceBundle.getBundle("jdbc");
        String url=bundle.getString("url");
        String user=bundle.getString("user");
        String password=bundle.getString("password");

        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;

        String LoginName=userLoginInfo.get("LoginName");
        String LoginPwd=userLoginInfo.get("LoginPwd");

        boolean LoginSuccess=false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection= DriverManager.getConnection(url,user,password);

            String sql="select * from Login where username= ? and password=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,LoginName);
            ps.setString(2,LoginPwd);

            resultSet=ps.executeQuery();

            if (resultSet.next()){
                LoginSuccess=true;
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
            } if (ps != null) {
                try {
                    ps.close();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            } if (connection != null) {
                try {
                    connection.close();
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return LoginSuccess;
    }

    /**
     * 用户登录界面
     * @return
     */
    private static Map<String, String> initui() {
        Scanner sc = new Scanner(System.in);
        System.out.print("用户名：");
        String LoginName = sc.nextLine();

        System.out.print("密码:");
        String LoginPwd=sc.nextLine();

        Map<String,String> userLoginInfo=new HashMap<>();
        userLoginInfo.put("LoginName",LoginName);
        userLoginInfo.put("LoginPwd",LoginPwd);
        return  userLoginInfo;
    }
}
