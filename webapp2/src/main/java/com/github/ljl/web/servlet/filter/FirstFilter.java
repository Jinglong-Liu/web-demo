package com.github.ljl.web.servlet.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-25 10:45
 **/

public class FirstFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("[webapp2] Before web-demo FirstFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("[webapp2] After web-demo FirstFilter");
    }

    @Override
    public void destroy() {

    }
}
