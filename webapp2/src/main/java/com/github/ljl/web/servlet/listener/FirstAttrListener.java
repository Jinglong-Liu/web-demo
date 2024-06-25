package com.github.ljl.web.servlet.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-25 14:27
 **/

public class FirstAttrListener implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        String message = String.format("[webapp2] attribute added. name={%s},value={%s}",event.getName(), event.getValue());
        System.out.println(message);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        String message = String.format("[webapp2] attribute removed. name={%s},value={%s}",event.getName(), event.getValue());
        System.out.println(message);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        String message = String.format("[webapp2] attribute removed. name={%s},value={%s}",event.getName(), event.getValue());
        System.out.println(message);
    }
}
