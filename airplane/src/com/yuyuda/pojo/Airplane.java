package com.yuyuda.pojo;

public class Airplane {
    private int id;
    private String airNo;
    private double price;
    private int time;
    private Airport takePort;
    private Airport LandPort;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAirNo() {
        return airNo;
    }

    public void setAirNo(String airNo) {
        this.airNo = airNo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Airport getTakePort() {
        return takePort;
    }

    public void setTakePort(Airport takePort) {
        this.takePort = takePort;
    }

    public Airport getLandPort() {
        return LandPort;
    }

    public void setLandPort(Airport landPort) {
        LandPort = landPort;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", airNo='" + airNo + '\'' +
                ", price=" + price +
                ", time=" + time +
                ", takePort=" + takePort +
                ", LandPort=" + LandPort +
                '}';
    }
}
