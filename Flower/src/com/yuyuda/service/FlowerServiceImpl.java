package com.yuyuda.service;

import com.yuyuda.dao.FlowerDao;
import com.yuyuda.dao.FlowerDaoImpl;
import com.yuyuda.pojo.Flower;

import java.util.List;

public class FlowerServiceImpl implements FlowerService {
    private FlowerDao flowerDao = new FlowerDaoImpl();

    @Override
    public List<Flower> show() {
        return flowerDao.selAll();
    }

    @Override
    public int add(Flower flower) {
        return flowerDao.insFlower(flower);
    }
}
