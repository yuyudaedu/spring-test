package com.yuyuda.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@WebServlet("/validcode")
public class ValidCodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一张图片
        BufferedImage bufferedImage = new BufferedImage(200, 100, BufferedImage.TYPE_INT_RGB);

        //创建画板
        Graphics2D graphics = bufferedImage.createGraphics();
        //取画笔
        graphics.setColor(Color.WHITE);
        //填充
        graphics.fillRect(0, 0, 200, 100);
        //随机串
        ArrayList<Integer> randList = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            randList.add(random.nextInt(10));
        }

        //设置字体
        graphics.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 50 + random.nextInt(5) - 5));
        //往画板上写字
        Color[] colors = new Color[]{Color.BLACK, Color.BLUE, Color.GRAY, Color.GREEN, Color.ORANGE};
        for (int i = 0; i < randList.size(); i++) {
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawString(randList.get(i) + "", i * 50, 70 + random.nextInt(21) - 10);
        }

        for (int i = 0; i < 2; i++) {
            graphics.setColor(colors[random.nextInt(colors.length)]);
            graphics.drawLine(0, random.nextInt(101), 200, random.nextInt(101));
        }

        //获取响应流
        ServletOutputStream outputStream = resp.getOutputStream();

        //imageIO工具类
        ImageIO.write(bufferedImage, "jpg", outputStream);

        //将验证码存入session
        HttpSession session = req.getSession();

        StringBuilder result = new StringBuilder();
        for (Integer str : randList) {
            result.append(str);
        }
        session.setAttribute("code", result.toString());
    }
}
