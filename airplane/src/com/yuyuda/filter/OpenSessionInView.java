package com.yuyuda.filter;

import com.yuyuda.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter
public class OpenSessionInView implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        SqlSession session = MybatisUtil.getSession();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
            session.commit();
        } catch (IOException | ServletException e) {
            session.rollback();
            e.printStackTrace();
        } finally {
            MybatisUtil.closeSession();
        }
    }

    @Override
    public void destroy() {

    }
}
