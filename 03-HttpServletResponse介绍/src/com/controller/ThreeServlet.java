package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ThreeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result="java<br/>mysql<br/>HTML<br/>";
        String result2="数字<br/>字符<br/>数组<br/>";
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out =response.getWriter();
        out.print(result);
        out.print(result2);
    }
}
