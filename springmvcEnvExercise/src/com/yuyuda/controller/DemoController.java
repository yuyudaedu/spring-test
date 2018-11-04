package com.yuyuda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;

@Controller
public class DemoController {
    @RequestMapping("demo1")
    public String demo1(ServletRequest request) {
        request.setAttribute("demo1", "12323");
        return "index";
    }
}
