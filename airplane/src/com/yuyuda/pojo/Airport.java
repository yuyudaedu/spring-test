package com.yuyuda.pojo;

public class Airport {
    private int id;
    private String portname;
    private String cityname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPortname() {
        return portname;
    }

    public void setPortname(String portname) {
        this.portname = portname;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id=" + id +
                ", portname='" + portname + '\'' +
                ", cityname='" + cityname + '\'' +
                '}';
    }
}
