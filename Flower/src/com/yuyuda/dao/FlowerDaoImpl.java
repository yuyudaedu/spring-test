package com.yuyuda.dao;

import com.yuyuda.pojo.Flower;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据访问层要有异常处理
 */
public class FlowerDaoImpl implements FlowerDao {

    @Override
    public List<Flower> selAll() {
        List<Flower> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssm?useSSL=false", "root", "123456");
            ps = conn.prepareStatement("SELECT * FROM `flower`");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Flower(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getString(4)));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public int insFlower(Flower flower) {
        Connection conn = null;
        PreparedStatement ps = null;
        int index = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/ssm?useSSL=false", "root", "123456");
            ps = conn.prepareStatement("INSERT INTO `flower` VALUES (DEFAULT, ?, ?, ?)");
            ps.setObject(1, flower.getName());
            ps.setObject(2, flower.getPrice());
            ps.setObject(3, flower.getProduction());
            index = ps.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return index;
    }
}
