package com.github.ljl.servlet.web.util;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-23 11:31
 **/

public class HttpUtil {
    public static String http200Resp(String rawText) {
        String format = "HTTP/1.1 200 OK\r\n" +
                "Content-Type: text/plain\r\n" +
                "\r\n" +
                "%s";

        return String.format(format, rawText);
    }
}
