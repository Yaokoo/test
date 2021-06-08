package com.controller;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String goodsName;
        goodsName=request.getParameter("goodsName");
        HttpSession session =request.getSession();
        Integer num=(Integer)session.getAttribute(goodsName);
        if(num==null){
            session.setAttribute(goodsName,1);
        }else {
            session.setAttribute(goodsName,num+1);
        }
    }
}
