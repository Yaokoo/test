package com.controller;

import com.dao.UserDao;
import com.entity.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class UserFindServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao=new UserDao();
        List<Users> usersList= dao.findAll();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();
        out.print("<table border='2' align='center'>");
        out.print("<tr>");
        out.print("<td>用户编号</td>");
        out.print("<td>用户名称</td>");
        out.print("<td>用户密码</td>");
        out.print("<td>用户性别</td>");
        out.print("<td>用户邮箱</td>");
        out.print("<td>操作</td>");
        out.print("</tr>");
        for(Users users:usersList){
            out.print("<tr>");
            out.print("<td>"+users.getUserId()+"</td>");
            out.print("<td>"+users.getUserName()+"</td>");
            out.print("<td>******</td>");
            out.print("<td>"+users.getSex()+"</td>");
            out.print("<td>"+users.getEmail()+"</td>");
            out.print("<td><a href='/myWeb/user/delete?userId="+users.getUserId()+"'>删除用户</a></td>");
            out.print("</tr>");
        }
        out.print("</table>");
    }
}
