package com.yuyuda.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        Demo demo = context.getBean("demo", Demo.class);
        demo.demo1();
        //demo.demo2();
        //demo.demo3();
    }
}
