package com.yuyuda.advice;


public class MyThrowAdvice {
    public void myException(Exception e) {
        System.out.println("异常通知执行: " + e.getMessage());
    }
}
