package com.github.ljl.web.servlet.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-25 20:17
 **/

public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("context-attr1-name", "context-attr1-value");
        event.getServletContext().setAttribute("context-attr2-name", "context-attr2-value");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        ServletContextListener.super.contextDestroyed(event);
    }
}
