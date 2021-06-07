package com.controller;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

public class oneServlet extends javax.servlet.http.HttpServlet {

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        System.out.println("oneServlet执行");
        RequestDispatcher report=request.getRequestDispatcher("/two");
        report.forward(request,response);
    }
}
