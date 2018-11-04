package com.yuyuda.service.impl;

import com.yuyuda.mapper.AirportMapper;
import com.yuyuda.pojo.Airport;
import com.yuyuda.service.AirportService;

import java.util.List;

public class AirportServiceImpl implements AirportService {
    private AirportMapper airportMapper;

    public AirportMapper getAirportMapper() {
        return airportMapper;
    }

    public void setAirportMapper(AirportMapper airportMapper) {
        this.airportMapper = airportMapper;
    }

    @Override
    public List<Airport> show() {
        return airportMapper.selAll();
    }
}
