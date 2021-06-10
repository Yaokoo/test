package com.filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class OneFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String age=servletRequest.getParameter("age");
        if(Integer.valueOf(age)<70){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            servletResponse.setContentType("text/html;charset:ust-8");
            PrintWriter out=servletResponse.getWriter();
            out.print("<center><font style='color:red;font-size:40px'>xxx</font></center>");
        }
    }

    @Override
    public void destroy() {

    }
}
