package com.util;

import javax.xml.transform.Result;
import java.sql.*;

public class JdbcUtil {
    private Connection con=null;
    private PreparedStatement ps=null;
    private  ResultSet rs=null;

    static{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Connection createCon(){
        try {
            con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bjpowernode?serverTimezone=Asia/Shanghai","root","root");
        } catch (Exception throwables) {
            throwables.printStackTrace();
            System.out.println("connection对象创建失败");
        }
        return con;
    }
    public PreparedStatement CreateStatement(String sql){
        try {
            ps=createCon().prepareStatement(sql);
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return ps;
    }
    public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (preparedStatement != null) {
            try {
                preparedStatement.close();
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
