package com.github.ljl.web.servlet.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-25 10:45
 **/

public class SecondFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("[webapp2] Before web-demo SecondFilter");
        chain.doFilter(request, response);
        System.out.println("[webapp2] After web-demo SecondFilter");
    }

    @Override
    public void destroy() {

    }
}
