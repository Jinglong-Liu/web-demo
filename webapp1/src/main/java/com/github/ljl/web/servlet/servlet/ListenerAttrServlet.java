package com.github.ljl.web.servlet.servlet;

import com.github.ljl.web.lib.util.HttpUtil;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-25 14:11
 **/

public class ListenerAttrServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext context = req.getServletContext();
        String key = "man";
        System.out.println("[webapp1] before attr set");
        context.setAttribute(key, "What can I say");
        System.out.println("[webapp1] after set man");
        context.setAttribute(key, "Tomcat out!");
        System.out.println("[webapp1] after replace man");
        final String attribute = (String) context.getAttribute(key);
        System.out.println(String.format("[webapp1] get key={%s}, value={%s}", key, attribute));
        context.removeAttribute(key);
        System.out.println("[webapp1] after remove man");
        System.out.println(String.format("[webapp1] get key={%s}, value={%s}", key, context.getAttribute(key)));
        resp.getWriter().print(HttpUtil.http200Resp(attribute));
        resp.flushBuffer();
    }
}
