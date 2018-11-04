package com.yuyuda.mapper;

import com.yuyuda.pojo.Airplane;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirplaneMapper {
    List<Airplane> selPlaneByTakeIdAndLandId(@Param("takeid") int takeid, @Param("landid") int landid);
}
