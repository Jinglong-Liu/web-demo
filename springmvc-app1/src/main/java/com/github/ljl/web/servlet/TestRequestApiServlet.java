package com.github.ljl.web.servlet;

import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-28 09:16
 **/

@WebServlet("/test/request/api")
public class TestRequestApiServlet extends HttpServlet {
    public TestRequestApiServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ContentType:" + req.getContentType());
        System.out.println("Method:" + req.getMethod());
        System.out.println("ServletPath:" + req.getServletPath());
        System.out.println("ServletName:" + req.getServerName());
        System.out.println("URI:" + req.getRequestURI());
        System.out.println("URL: " + req.getRequestURL());
        System.out.println(req);

        resp.setContentType("application/json");
        String jsonStr = "{\"servlet\":\"TestRequestApiServlet\"}";
        Writer writer = resp.getWriter();
        writer.write(jsonStr);
        writer.flush();
    }
}
