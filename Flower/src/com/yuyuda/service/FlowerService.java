package com.yuyuda.service;

import com.yuyuda.pojo.Flower;

import java.util.List;

public interface FlowerService {
    /**
     * 显示所有花卉信息
     * @return
     */
    List<Flower> show();

    /**
     * 添加花卉
     * @param flower
     * @return
     */
    int add(Flower flower);
}
