package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet extends javax.servlet.http.HttpServlet {
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String result="Hello World";
        PrintWriter out =response.getWriter();
        out.write(result);
    }
}
