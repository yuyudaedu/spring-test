package com.yuyuda.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class MyBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(method);
        System.out.println(method.getName());
        System.out.println(objects);
        System.out.println(o);
        System.out.println("输出前置通知");
    }
}
