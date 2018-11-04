package com.yuyuda.servlet;

import com.yuyuda.pojo.User;
import com.yuyuda.service.UserService;
import com.yuyuda.service.impl.UserServiceImpl;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class UserLoginservlet extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        userService = context.getBean("userService", UserServiceImpl.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String code = req.getParameter("code");
        String sessionCode = req.getSession().getAttribute("code").toString();
        if (code.equals(sessionCode)) {
            String name = req.getParameter("name");
            String password = req.getParameter("password");
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            User login = userService.login(user);
            if (login != null) {
                resp.sendRedirect("main.jsp");
            } else {
                req.setAttribute("error", "用户名或密码不正确");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "验证码不正确");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
    }
}
