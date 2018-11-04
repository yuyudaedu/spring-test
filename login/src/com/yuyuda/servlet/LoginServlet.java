package com.yuyuda.servlet;

import com.yuyuda.pojo.User;
import com.yuyuda.service.UserService;
import com.yuyuda.service.impl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() throws ServletException {
        ApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean("userService", UserServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setPassword(req.getParameter("password"));
        User login = userService.login(user);
        if (login != null) {
            resp.sendRedirect("main.jsp");
        } else {
            resp.sendRedirect("index.jsp");
        }
    }
}
