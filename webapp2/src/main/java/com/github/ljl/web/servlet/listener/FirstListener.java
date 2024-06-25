package com.github.ljl.web.servlet.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-25 10:56
 **/

public class FirstListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        String message = String.format("[webapp2] attribute added. name={},value={}",event.getName(), event.getValue());
        System.out.println(message);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        String message = String.format("[webapp2] attribute removed. name={},value={}",event.getName(), event.getValue());
        System.out.println(message);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        String message = String.format("[webapp2] attribute removed. name={},value={}",event.getName(), event.getValue());
        System.out.println(message);
    }
}
