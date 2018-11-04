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
import java.util.List;

@WebServlet("/show")
public class ShowServlet extends HttpServlet{
    private FlowerService flowerService = new FlowerServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Flower> list = flowerService.show();
        req.setAttribute("list", list);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
