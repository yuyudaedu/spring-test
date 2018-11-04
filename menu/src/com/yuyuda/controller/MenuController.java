package com.yuyuda.controller;

import com.yuyuda.pojo.Menu;
import com.yuyuda.service.MenuService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

@Controller
public class MenuController {

    @Resource
    private MenuService menuServiceImpl;

    @RequestMapping("show")
    @ResponseBody
    public List<Menu> show() {
        return menuServiceImpl.show();
    }

    @RequestMapping("download")
    public void download(String file, HttpServletRequest req, HttpServletResponse res) throws IOException {
        //设置下载响应头信息
        res.setHeader("Content-Disposition", "attachment;filename=a.txt");
        //获取响应输出流对象
        ServletOutputStream outputStream = res.getOutputStream();
        //获取文件所在路径
        String path = req.getServletContext().getRealPath("files");
        //获取文件对象
        File file1 = new File(path, file);
        //利用apache文件上传下载接口，将文件转成二进制字节数组
        byte[] bytes = FileUtils.readFileToByteArray(file1);
        //输出流
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }

    @RequestMapping("upload")
    public String upload(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
        String uuid = UUID.randomUUID().toString();
        FileUtils.copyInputStreamToFile(inputStream, new File("D:\\java\\javaweb\\menu\\web\\files\\" + uuid + suffix));
        return "index";
    }
}
