package com.yuyuda.service.impl;

import com.yuyuda.mapper.AirplaneMapper;
import com.yuyuda.pojo.Airplane;
import com.yuyuda.service.AirplaneService;
import com.yuyuda.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AirplaneServiceImpl implements AirplaneService {
    @Override
    public List<Airplane> show(int takeid, int landid) {
        SqlSession session = MybatisUtil.getSession();
        AirplaneMapper mapper = session.getMapper(AirplaneMapper.class);
        return mapper.selPlaneByTakeIdAndLandId(takeid, landid);
    }
}
