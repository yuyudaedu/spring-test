package com.yuyuda.servlet;

import com.yuyuda.pojo.Airplane;
import com.yuyuda.service.AirplaneService;
import com.yuyuda.service.impl.AirplaneServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ShowAirplaneServlet extends HttpServlet {
    private AirplaneService airplaneService = new AirplaneServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String takeIdStr = req.getParameter("takeid");
        String landIdStr = req.getParameter("landid");
        int takeid = takeIdStr != null && !takeIdStr.equals("") ? Integer.parseInt(takeIdStr) : 0;
        int landid = landIdStr != null && !landIdStr.equals("") ? Integer.parseInt(landIdStr) : 0;

        List<Airplane> airplaneList = airplaneService.show(takeid, landid);
        req.setAttribute("list", airplaneList);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
