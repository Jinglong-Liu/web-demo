package com.github.ljl.web.springmvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-30 15:54
 **/

@Configuration
@ComponentScan(value = "com.github.ljl.web.springmvc")
public class WebConfig implements WebMvcConfigurer {

}
