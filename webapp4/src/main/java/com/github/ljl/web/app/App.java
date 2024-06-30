//package com.github.ljl.web.app;
//
//import com.github.ljl.web.servlet.TestRequestApiServlet;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.startup.Tomcat;
//
//import java.io.File;
//
///**
// * @program: web-demo
// * @description: 仅测试
// * @author: ljl
// * @create: 2024-06-28 09:30
// **/
//
//public class App {
//    public static void main(String[] args) throws LifecycleException {
//        String webappDirLocation = "webapp4/src/main/webapp/";
//        Tomcat tomcat = new Tomcat();
//
//        tomcat.setPort(8081);
//
//        String webappPath = new File(webappDirLocation).getAbsolutePath();
//        System.out.println(webappPath);
//        tomcat.addWebapp("/", webappPath);
//
//        tomcat.start();
//        tomcat.getServer().await();
//    }
//}
