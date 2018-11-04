package com.yuyuda.test;

import com.yuyuda.pojo.People;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        People people = context.getBean("peo", People.class);

        System.out.println(people);
    }
}
