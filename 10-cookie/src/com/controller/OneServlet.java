package com.controller;

import javax.servlet.http.Cookie;
import java.io.IOException;

public class OneServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //读取请求头中的信息
        String userName=request.getParameter("userName");
        String money=request.getParameter("money");
        //开卡
        Cookie card1=new Cookie("userName",userName);
        Cookie card2=new Cookie("money",money);
        //发卡
        response.addCookie(card1);
        response.addCookie(card2);
        //将点餐页面交给浏览器（请求转发）
        request.getRequestDispatcher("/index_2.html").forward(request,response);
    }
}
