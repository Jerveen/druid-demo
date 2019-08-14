package com.sunchong.demo.controller;

import com.sunchong.demo.utils.FileUtils;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Description: 文件上传下载Controller
 * @Author: xyw
 * @CreateDt: 2019-08-13
 */
@Controller
@RequestMapping("/fileHandler")
@Slf4j
public class FileHandlerController {

    @Value("${file.upload.path}")
    private String fileUploadPath;

    /**
     * 跳转到上传文件的页面
     *
     * @return
     */
    @GetMapping("/uploadFile")
    public String goUploadImg() {
        // 跳转到 templates 目录下的 fileupload.html
        return "fileupload";
    }

    /**
     * 处理文件上传
     *
     * @param file
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("uploadFileAction")
    public String uploadImg(@RequestParam("file") MultipartFile file,
                            HttpServletRequest request) {
        try {
            // 判断非空
            if (file.isEmpty()) {
                return "no file is uploading";
            }
            String fileName = file.getOriginalFilename();
            try {
                FileUtils.uploadFile(file.getBytes(), fileUploadPath, fileName);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("upload file action is error", e, this.getClass());
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("upload file is error", e, this.getClass());
            return "upload file error";
        }
        //返回json
        return "upload file success";
    }

    /**
     * 处理下载文件
     *
     * @param request
     * @param response
     */
    @PostMapping("downloadFileAction")
    public void downloadFileAction(HttpServletRequest request, HttpServletResponse response) {

        // 设置请求编码已经类型
        response.setCharacterEncoding(request.getCharacterEncoding());
        response.setContentType("application/octet-stream");

        // 初始化变量
        FileInputStream fis = null;
        try {
            // 此处文件地址写死, 实际项目中药手动获取或用其他方式获取
            File file = new File("D:/sunchong-demo/src/main/resources/upload/4781442-d6a8c2e5714b4c44.png");
            fis = new FileInputStream(file);
            // 设置请求头
            response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
            // 写数据
            IOUtils.copy(fis, response.getOutputStream());
            response.flushBuffer();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
