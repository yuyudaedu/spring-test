package com.yuyuda.service.impl;

import com.yuyuda.mapper.AirportMapper;
import com.yuyuda.pojo.Airport;
import com.yuyuda.service.AirportService;
import com.yuyuda.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirportServiceImpl implements AirportService {
    @Override
    public List<Airport> showTakePort() {
        SqlSession session = MybatisUtil.getSession();
        AirportMapper mapper = session.getMapper(AirportMapper.class);

        return mapper.selTakePort();
    }

    @Override
    public List<Airport> showLandPort() {
        SqlSession session = MybatisUtil.getSession();
        AirportMapper mapper = session.getMapper(AirportMapper.class);
        return mapper.selLandPort();
    }
}
