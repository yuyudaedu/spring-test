package com.yuyuda.mapper;

import com.yuyuda.pojo.Airport;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AirportMapper {

    @Select("SELECT * FROM `airport` WHERE `id` IN(SELECT DISTINCT `takeid` FROM `airplane`)")
    List<Airport> selTakePort();

    @Select("SELECT * FROM `airport` WHERE `id` IN(SELECT DISTINCT `landid` FROM `airplane`)")
    List<Airport> selLandPort();
}
