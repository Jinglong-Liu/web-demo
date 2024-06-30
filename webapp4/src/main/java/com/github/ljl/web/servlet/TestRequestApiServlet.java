package com.github.ljl.web.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-28 09:28
 **/
import java.nio.charset.IllegalCharsetNameException;
public class TestRequestApiServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AuthType: " + req.getAuthType());
        System.out.println("ContextPath: " + req.getContextPath());
        System.out.println("ContentType:" + req.getContentType());
        System.out.println("CharacterEncoding:" + req.getCharacterEncoding());
        System.out.println("Method:" + req.getMethod());
        System.out.println("ServletPath:" + req.getServletPath());
        System.out.println("ServletName:" + req.getServerName());
        System.out.println("URI:" + req.getRequestURI());
        System.out.println("URL: " + req.getRequestURL());
        System.out.println("PathInfo:" + req.getPathInfo());
        System.out.println("ContentLength " + req.getContentLength());
        System.out.println("ContentLengthLong " + req.getContentLengthLong());
        System.out.println("DispatcherType: " + req.getDispatcherType());
        System.out.println(req);

        System.out.println("AttributeNames:\n");
        if (Objects.nonNull(req.getAttributeNames())) {
            List<String> attributeNames = Collections.list(req.getAttributeNames());
            attributeNames.forEach(name -> {
                System.out.println(name + " ");
            });
        }

        if (Objects.nonNull(req.getParameterNames())) {
            List<String> parameterNames = Collections.list(req.getParameterNames());
            System.out.println("Parameter:");
            parameterNames.forEach(name -> {
                System.out.println(name + " " + req.getParameter(name));
            });
            System.out.println();
            System.out.println("Multi Parameter[]:");
            parameterNames.forEach(name -> {
                System.out.println("paramName=" + name);
                String[] values = req.getParameterValues(name);
                System.out.print("paramValues=");
                Arrays.stream(values).forEach(value -> {
                    System.out.print(value + ",");
                });
                System.out.println();
            });
        }


        System.out.println();
        InputStream inputStream = req.getInputStream();
        System.out.println("parse inputStream");
        // 读取并处理文本内容
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }


        System.out.println("parse body:");
        // json/application 格式的request body
        ObjectMapper objectMapper = new ObjectMapper();





//        Map<String, Object> jsonMapper = objectMapper.readValue(req.getInputStream(), Map.class);
//        jsonMapper.entrySet().forEach(entry -> {
//            System.out.println("json body:key=" + entry.getKey() + ",value=" + entry.getValue());
//        });


        // auth
        System.out.println("parse auth");
        System.out.println("AuthType:" + req.getAuthType());

        resp.setContentType("application/json");
        String jsonStr = "{\"servlet\":\"TestRequestApiServlet\"}";
        Writer writer = resp.getWriter();
        writer.write(jsonStr);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();

        System.out.println("servletContext=" + servletContext.getContextPath());
        // servletContext.getContext("uri");
    }
}
