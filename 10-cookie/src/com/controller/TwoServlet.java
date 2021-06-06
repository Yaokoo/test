package com.controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class TwoServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int jiaozi_money = 30;
        int miantiao_money = 20;
        int gaifan_money = 25;
        Cookie[] cookies = null;
        String userName = null,food=null;
        Cookie newcard = null;
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int money = 0,xiaoafei=0,balance=0;

        food = request.getParameter("food");
        cookies = request.getCookies();
        for (Cookie card : cookies) {
            String key= card.getName();
            String value = card.getValue();
            if ("userName".equals(key)) {
                userName = value;
            } else if ("money".equals(key)) {
                money = Integer.valueOf(value);
                if("饺子".equals(food)){
                    if(money<jiaozi_money){
                        out.print("用户"+userName+"余额不足，请充值");
                    }else {
                        newcard=new Cookie("money",(money-jiaozi_money)+"");
                        xiaoafei=jiaozi_money;
                        balance=money-xiaoafei;
                    }
                }else if("面条".equals(food)){
                    if(money<miantiao_money){
                        out.print("用户"+userName+"余额不足，请充值");
                    }else {
                        newcard=new Cookie("money",(money-miantiao_money)+"");
                        xiaoafei=miantiao_money;
                        balance=money-xiaoafei;
                    }
                }if("盖饭".equals(food)){
                    if(money<gaifan_money){
                        out.print("用户"+userName+"余额不足，请充值");
                    }
                    else {
                        newcard=new Cookie("money",(money-gaifan_money)+"");
                        xiaoafei=gaifan_money;
                        balance=money-xiaoafei;
                    }
                }
            }
        }
        response.addCookie(newcard);
        out.print("用户"+userName+"本次消费"+xiaoafei+"余额"+balance);
    }
}
