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
 * @description:
 * @author: ljl
 * @create: 2024-06-25 10:39
 **/

public class HttpServletDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String context = "[webapp2] http index get using writer";
        PrintWriter writer = response.getWriter();
        writer.print(HttpUtil.http200Resp(context));
        response.flushBuffer();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String context = "[webapp2] http index post using outputStream";
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.print(HttpUtil.http200Resp(context));
        response.flushBuffer();
    }
}
