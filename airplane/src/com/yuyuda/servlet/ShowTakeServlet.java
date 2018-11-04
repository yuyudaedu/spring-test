package com.yuyuda.servlet;

import com.yuyuda.service.AirportService;
import com.yuyuda.service.impl.AirportServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/showtake")
public class ShowTakeServlet extends HttpServlet {
    private AirportService airportService = new AirportServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("takeport", airportService.showTakePort());
        req.getRequestDispatcher("showland").forward(req, resp);
    }
}
