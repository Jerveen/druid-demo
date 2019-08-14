package com.sunchong.demo.utils;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Description: 上传文件工具类
 * @Author: xyw
 * @CreateDt: 2019-08-13
 */
@Slf4j
public class FileUtils {

    public static void uploadFile(byte[] file, String filePath, String fileName) {
        // 变量初始化
        FileOutputStream out = null;
        try {
            File targetFile = new File(filePath);
            // 如果是文件夹, 判断是否存在, 不存在则新建
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            out = new FileOutputStream(filePath + fileName);
            out.write(file);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("upload file is error", e);
        } finally {
            if (out != null) {
                try {
                    // 关闭流
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    log.error("turn down the io is error", e);
                }
            }
        }
    }
}
