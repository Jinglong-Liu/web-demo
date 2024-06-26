package com.github.ljl.web.servlet.servlet;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.ljl.web.lib.util.HttpUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @program: web-demo
 * @description:
 * @author: ljl
 * @create: 2024-06-25 19:42
 **/

public class TestServletApiServlet extends HttpServlet {

    private static String PASS = "pass";
    private static String FAIL = "failed";

    static private class TestResult {
        @JsonProperty
        String result;

        @JsonProperty
        String message;

        public TestResult() {

        }
        public TestResult(String result, String message) {
            this.result = result;
            this.message = message;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public String getResult() {
            return result;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, TestResult> data = new HashMap<>();

        // testcase1
        if ("servlet-api-test-servlet".equals(getServletName())) {
            data.put("testcase1", new TestResult(PASS, ""));
        } else {
            data.put("testcase1", new TestResult(FAIL, "getServletName() error"));
        }

        // testcase2
        if ("servlet-init-param1-value".equals(getInitParameter("servlet-init-param1-name"))) {
            data.put("testcase2", new TestResult(PASS,""));
        } else {
            data.put("testcase2", new TestResult(FAIL, "getInitParameter(name) error"));
        }

        // testcase3
        Set<String> servletParams = Arrays.stream(new String[]{
                "servlet-init-param1-name", "servlet-init-param2-name"
        }).collect(Collectors.toSet());
        if (servletParams.equals(enumerationToSet(getInitParameterNames()))) {
            data.put("testcase3", new TestResult(PASS,""));
        } else {
            data.put("testcase3", new TestResult(FAIL, "getInitParameter(name) error"));
        }

        // testcase4
        ServletContext context = getServletContext();
        if ((Objects.nonNull(context)) && context == req.getServletContext()) {
            data.put("testcase4", new TestResult(PASS,""));
        } else {
            data.put("testcase4", new TestResult(FAIL, "getServletContext() error"));
        }

        // testcase5
        if ("context-init-param1-value".equals(context.getInitParameter("context-init-param1-name"))) {
            data.put("testcase5", new TestResult(PASS,""));
        } else {
            data.put("testcase5", new TestResult(FAIL, "context.getInitParameter(name) error"));
        }

        // testcase6
        Set<String> contextParamNames = Arrays.stream(new String[]{
                "context-init-param1-name", "context-init-param2-name"
        }).collect(Collectors.toSet());

        if (contextParamNames.equals(enumerationToSet(context.getInitParameterNames()))) {
            data.put("testcase6", new TestResult(PASS,""));
        } else {
            data.put("testcase6", new TestResult(FAIL, "context.getInitParameterNames() error"));
        }

        // testcase7
        if ("context-attr1-value".equals(context.getAttribute("context-attr1-name"))) {
            data.put("testcase7", new TestResult(PASS,""));
        } else {
            data.put("testcase7", new TestResult(FAIL, "context.getAttribute(name) error"));
        }


        // test8
        Set<String> contextAttrNames = Arrays.stream(new String[]{
                "context-attr1-name", "context-attr2-name"
        }).collect(Collectors.toSet());
        if (contextAttrNames.equals(enumerationToSet(context.getAttributeNames()))) {
            data.put("testcase8", new TestResult(PASS,""));
        } else {
            data.put("testcase8", new TestResult(FAIL, "context.getAttributeNames() error"));
        }

        Long passedTests = data.values().stream().filter(testResult -> testResult.result.equals(PASS)).count();
        Long failedTests = data.values().stream().filter(testResult -> testResult.result.equals(FAIL)).count();

        data.put("passedTests", new TestResult(String.valueOf(passedTests), ""));
        data.put("failedTests", new TestResult(String.valueOf(failedTests), ""));
        if (failedTests.longValue() == 0) {
            data.put("result", new TestResult("All Testcases Pass", ""));
        } else {
            data.put("result", new TestResult("Some Testcases Failed", ""));
        }

        List<String> keySet = new ArrayList<>(data.keySet());
        Collections.sort(keySet);
        keySet.forEach(key -> {
            System.out.println(key + " " + data.get(key).result + " " + data.get(key).message);
        });

        // resp.setContentType("application/json");
        // resp.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(data);
        // resp.getWriter().print(json);
        resp.getWriter().write(HttpUtil.http200Resp(json));
        resp.flushBuffer();
    }
    public static <T> Set<T> enumerationToSet(Enumeration<T> enumeration) {
        Set<T> set = new HashSet<>();
        while (enumeration.hasMoreElements()) {
            set.add(enumeration.nextElement());
        }
        return set;
    }
}
