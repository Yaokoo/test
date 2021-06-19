package com.jdbc;

import com.jdbc.utils.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest12 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            connection=DBUtil.getConnection();
            String sql="select ename from emp where ename like ?";
            ps=connection.prepareStatement(sql);
            ps.setString(1,"_A%");
            rs=ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("ename"));
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally {
            DBUtil.close(connection,ps,rs);
        }
    }
}
