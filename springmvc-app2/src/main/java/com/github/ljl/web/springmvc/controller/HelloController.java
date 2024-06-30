package com.github.ljl.web.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-30 15:55
 **/

@Controller
public class HelloController {
    @RequestMapping(value = "hello/json", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String jsonMethod() {
        String jsonStr = "{\"result\":\"hello jsonMethod() springmvc-app2\"}";
        return jsonStr;
    }
    @RequestMapping(value = "json", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String json() {
        String jsonStr = "{\"result\":\"hello json() springmvc-app2\"}";
        return jsonStr;
    }
}
