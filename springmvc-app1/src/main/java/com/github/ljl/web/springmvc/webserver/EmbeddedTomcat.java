//package com.github.ljl.web.springmvc.webserver;
//
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.startup.Tomcat;
//import org.springframework.beans.factory.support.AbstractBeanDefinition;
//import org.springframework.beans.factory.support.AbstractBeanDefinitionReader;
//
//import javax.servlet.ServletException;
//import java.io.File;
//
///**
// * @program: web-demo
// * @description: 仅测试用
// * @author: ljl
// * @create: 2024-06-27 10:45
// **/
//
//public class EmbeddedTomcat {
//    public static void main(String[] args) throws LifecycleException, ServletException {
//
//        Tomcat tomcat = new Tomcat();
//        tomcat.setPort(8080);
//
//        // 设置上下文路径和 Web 应用目录
//        String contextPath = "";
//        String webappDirLocation = "springmvc-app1/src/main/webapp/";
//
//        tomcat.addWebapp(contextPath, new File(webappDirLocation).getAbsolutePath());
//        System.out.println("Configuring app with basedir: " + new File("./" + webappDirLocation).getAbsolutePath());
//
//        tomcat.start();
//        tomcat.getServer().await();
//    }
//}
