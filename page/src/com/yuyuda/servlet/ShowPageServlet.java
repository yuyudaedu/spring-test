package com.yuyuda.servlet;

import com.yuyuda.pojo.PageInfo;
import com.yuyuda.service.PeopleService;
import com.yuyuda.service.impl.PeopleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/page")
public class ShowPageServlet extends HttpServlet {
    private PeopleService peopleService = new PeopleServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收前端传过来的参数
        String pageSizeStr = req.getParameter("pageSize");
        String pageStr = req.getParameter("page");
        int pageSize = 1;
        int page = 1;
        if (pageSizeStr != null && pageSizeStr == "") {
            pageSize = Integer.parseInt(pageSizeStr);
        }

        if (pageStr != null && pageStr != "") {
            page = Integer.parseInt(pageStr);
        }

        PageInfo pageInfo = peopleService.showPage(pageSize, page);
        req.setAttribute("pageInfo", pageInfo);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
