package com.github.ljl.web.servlet.servlet;

import com.github.ljl.web.lib.util.HttpUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program: web-demo
 * @description: 只使用HttpServlet提供的接口
 * @author: ljl
 * @since 0.5.1
 * @create: 2024-06-23 11:23
 **/

public class HttpServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String context = "[webapp1] http index get using writer";
        PrintWriter writer = response.getWriter();
        writer.print(HttpUtil.http200Resp(context));
        response.flushBuffer();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String context = "[webapp1] demo http index post using outputStream";
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.print(HttpUtil.http200Resp(context));
        response.flushBuffer();
    }
}
