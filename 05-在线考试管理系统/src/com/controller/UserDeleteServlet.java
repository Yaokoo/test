package com.controller;

import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UserDeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao=new UserDao();
        //读取请求头中的参数
        String userId=request.getParameter("userId");
        int value=0;
        value=dao.delete(userId);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        if (value==1){
            out.print("<center>用户删除成功</center>");
        }else {
            out.print("<center>用户删除失败</center>");
        }
    }
}
