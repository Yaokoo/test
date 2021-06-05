package com.controller;

import com.dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao=new UserDao();
        request.setCharacterEncoding("utf-8");
        int value=0;
        String userName=request.getParameter("userName");
        String passWord=request.getParameter("passWord");
        value=dao.Lgoin(userName,passWord);
        if (value==1){
            response.sendRedirect("/myWeb/index.html");
        }else {
            response.sendRedirect("/myWeb/error.html");
        }
    }
}
