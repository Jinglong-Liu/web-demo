package com.github.ljl.servlet.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @since 0.6.1
 * @create: 2024-06-23 22:43
 **/

public class FirstFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("[web-demo] Before web-demo FirstFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("[web-demo] After web-demo FirstFilter");
    }

    @Override
    public void destroy() {

    }
}
