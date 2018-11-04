package com.yuyuda.test;

import com.yuyuda.pojo.People;
import factory.PeopleFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        People peo = context.getBean("peo2", People.class);
        System.out.println(peo);

    }
}
