package com.yuyuda.lzx.dubbo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.yuyuda.lzx.dubbo.ServerApi;
import org.springframework.stereotype.Component;

@Component
public class DemoServiceImpl {

    @Reference
    ServerApi serverApi;

    public void demo(String msg) {
        System.out.println(serverApi.demo(msg));
    }
}
