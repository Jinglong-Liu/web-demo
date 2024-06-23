package com.github.ljl.servlet.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @since 0.5.0
 * @create: 2024-06-22 12:51
 **/

public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        writeToResponse(resp,"servlet index get");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        writeToResponse(resp,"servlet index post");
    }
    private void writeToResponse(HttpServletResponse resp, String content) {
        try {
            Class<?> responseClass = resp.getClass();
            Method writeMethod = responseClass.getMethod("write", String.class);
            writeMethod.invoke(resp, IndexServlet.http200Resp(content));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String http200Resp(String rawText) {
        String format = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/plain\r\n" +
                "\r\n" +
                "%s";

        return String.format(format, rawText);
    }
}
