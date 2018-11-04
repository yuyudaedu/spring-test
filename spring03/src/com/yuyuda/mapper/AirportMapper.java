package com.yuyuda.mapper;

import com.yuyuda.pojo.Airport;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AirportMapper {

    @Select("SELECT * FROM `airport`")
    List<Airport> selAll();
}
