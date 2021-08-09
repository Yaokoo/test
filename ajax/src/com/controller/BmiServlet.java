package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yaokoo
 * @create 2021/8/9 0:33
 */
public class BmiServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //String name=request.getParameter("name");
        String weight=request.getParameter("w");
        String high=request.getParameter("h");

        float w=Float.parseFloat(weight);
        float h=Float.parseFloat(high);
        float bmi=w/(h*h);

        //判断bmi的范围
        String msg="";
        if(bmi<18.5){
            msg="瘦";
        }else if(bmi>18.5&& bmi<=23.9){
            msg="正常";
        }else if(bmi>24&&bmi<=27){
            msg="胖";
        }else {
            msg="重开吧";
        }

        System.out.println("msg+"+msg);
        msg="你的bmi："+bmi+msg;

        //将数据存入request作用域
       /* request.setAttribute("msg",msg);
        //转发
        request.getRequestDispatcher("/reselt.jsp").forward(request,response);*/
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw =response.getWriter();
        pw.println(msg);
        pw.flush();
        pw.close();
    }
}
