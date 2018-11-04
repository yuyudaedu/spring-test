package com.yuyuda.advice;

import com.yuyuda.pojo.User;
import org.apache.log4j.Logger;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Date;

public class MyBefore implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        User user = (User) objects[0];
        Logger logger = Logger.getLogger(MyBefore.class);
        logger.info(user.getName() + "在" + new Date().toLocaleString() + "进行了登录！");
    }
}
