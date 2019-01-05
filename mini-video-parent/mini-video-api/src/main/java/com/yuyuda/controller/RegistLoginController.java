package com.yuyuda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/")
public class HelloworldController {

    @RequestMapping("world")
    public String world() {
        return "Hello Spring Boot ~~~";
    }
}
