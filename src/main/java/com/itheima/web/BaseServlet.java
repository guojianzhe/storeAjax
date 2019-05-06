package com.itheima.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

@WebServlet(name = "/")
public class BaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            //获取客户端提交的数据
            String md = request.getParameter("method");

            Class clazz = this.getClass();
            Method method = clazz.getMethod(md, HttpServletRequest.class, HttpServletResponse.class);

            method.invoke(this,request,response);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
