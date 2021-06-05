package com.controller;

import com.dao.UserDao;
import com.entity.Users;

import java.io.IOException;
import java.io.PrintWriter;

public class UserAddServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String userName,passWord,sex,email;
        UserDao dao=new UserDao();
        Users users=null;
        int result=0;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        //得到浏览器中的用户信息
        userName=request.getParameter("userName");
        passWord=request.getParameter("passWord");
        sex=request.getParameter("sex");
        email=request.getParameter("email");
        //通过userdao将用户信息填充到insert语句并借助jdbc规范发送到数据库服务器
        users=new Users(null,userName,passWord,sex,email);
        result=dao.add(users);
        if (result==1){
            out.print("<center>用户注册成功<center>");
        }else {
            out.print("<center>用户注册失败<center>");
        }
    }
}
