package com.yuyuda.dao;

import com.yuyuda.pojo.Flower;

import java.util.List;

public interface FlowerDao {
    /**
     * 查询全部
     * @return
     */
    List<Flower> selAll();

    /**
     * 添加花卉
     * @param flower
     * @return
     */
    int insFlower(Flower flower);
}
