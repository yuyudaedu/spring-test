package com.yuyuda.servlet;

import com.yuyuda.pojo.Flower;
import com.yuyuda.service.FlowerService;
import com.yuyuda.service.FlowerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insert")
public class insFlower extends HttpServlet {
    FlowerService flowerService = new FlowerServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        res.setCharacterEncoding("utf-8");
        //res.setContentType("Content-Type: text/html;charset=UTF-8");
        String name = req.getParameter("name");
        String price = req.getParameter("price");
        String production = req.getParameter("production");
        Flower flower = new Flower();
        flower.setName(name);
        flower.setPrice(Double.parseDouble(price));
        flower.setProduction(production);
        int index = flowerService.add(flower);
        if (index > 0) {
            res.sendRedirect("show");
        } else {
            res.sendRedirect("add.jsp");
        }
    }
}
