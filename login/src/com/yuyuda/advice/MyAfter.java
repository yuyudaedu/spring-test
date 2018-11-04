package com.yuyuda.advice;

import com.yuyuda.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class MyAfter implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        Logger logger = Logger.getLogger(this.getClass());
        User user = (User) objects[0];
        if (o != null) {
            logger.info(user.getName() + "登录成功！");
        } else {
            logger.info(user.getName() + "登录失败！");
        }
    }
}
