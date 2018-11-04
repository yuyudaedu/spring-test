package com.yuyuda.test;

import com.yuyuda.pojo.Airport;
import com.yuyuda.service.AirportService;
import com.yuyuda.service.impl.AirportServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Bean.xml");
        AirportService bean = context.getBean("airportService", AirportService.class);
        List<Airport> list = bean.show();
        System.out.println(list);
    }
}
