package com.yuyuda.controller;

import com.yuyuda.pojo.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    @RequestMapping("demo")
    public String demo(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) {
        System.out.println("name: " + name + "   " + password);

        return "main.jsp";
    }

    @RequestMapping("demo2")
    @ResponseBody
    public People demo2() {
        People peo = new People();
        peo.setAge(12);
        peo.setName("lzx");
        return peo;
    }

    @RequestMapping(value = "demo3", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String demo3() {
        return "中文";
    }
 }
