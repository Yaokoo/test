package com.dao;

import com.entity.Users;
import com.util.JdbcUtil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//用户注册实现
public class UserDao {
    JdbcUtil util=new JdbcUtil();
    public int add(Users users){
        String sql="insert into users(userName,passWord,sex,email) values (?,?,?,?)";
        PreparedStatement ps=util.CreateStatement(sql);
        int count = 0;
        try {
            ps.setString(1, users.getUserName());
            ps.setString(2, users.getPassWord());
            ps.setString(3, users.getSex());
            ps.setString(4, users.getEmail());
            count=ps.executeUpdate();
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }finally{
            JdbcUtil.close(util.createCon(),ps,null);
        }
        return count;
    }
    public List findAll(){
        String sql="select * from users";
        PreparedStatement ps=util.CreateStatement(sql);
        ResultSet rs=null;
        List usersList=new ArrayList<>();
        try {
            rs=ps.executeQuery();
            while (rs.next()){
                int userId=rs.getInt("userId");
                String userName=rs.getString("userName");
                String passWord=rs.getString("passWord");
                String sex=rs.getString("sex");
                String email=rs.getString("email");
                Users users=new Users(userId,userName,passWord,sex,email);
                usersList.add(users);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close(util.createCon(), ps,rs);
        }
        return usersList;
    }
    public int delete(String userID){
        String sql="delete from users where userId=?";
        PreparedStatement ps=util.CreateStatement(sql);
        int count=0;
        try {
            ps.setInt(1,Integer.valueOf(userID));
            count=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtil.close(util.createCon(), ps,null);
        }
        return count;
    }
    public int Lgoin(String userName,String passWord){
        ResultSet rs=null;
        int value=0;
        String sql="select count(*) from login where username=? and password=?";
        PreparedStatement ps=util.CreateStatement(sql);
        try {
            ps.setString(1,userName);
            ps.setString(2,passWord);
            rs=ps.executeQuery();
            if(rs.next()){
                value=rs.getInt("count(*)");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtil.close(util.createCon(),ps,rs);
        }
        return value;
    }
}
