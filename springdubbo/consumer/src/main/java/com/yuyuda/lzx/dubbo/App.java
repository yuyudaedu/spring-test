package com.yuyuda.lzx.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-hello-consumer.xml");
        context.start();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String msg = scanner.next();
            ServiceAPI serviceAPI = (ServiceAPI) context.getBean("demoService");
            for (int i=0;i<10;i++) {
                String demo = serviceAPI.demo(msg+i);
                System.out.println(demo+i);
            }
        }
    }
}
