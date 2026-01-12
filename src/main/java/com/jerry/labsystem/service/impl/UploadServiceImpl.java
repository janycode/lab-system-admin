package com.jerry.labsystem.service.impl;

import com.jerry.labsystem.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {

    /**
     * 上传
     *
     * @param file 要上传到的文件对象
     */
    @Override
    public void upload(MultipartFile file) throws IOException {
        // 用同文件进行存储和覆盖，因为就一张背景图
        String fileName = "bg.jpg";
        String filePath = ResourceUtils.getURL("classpath:").getPath() + "static/upload/";
        // fullFilePath: /E:/....../target/classes/static/upload/bg.jpg
        // 访问: http://localhost:5000/static/upload/bg.jpg
        String fullFilePath = filePath + fileName;
        System.out.println("fullFilePath = " + fullFilePath);
        File dist = new File(fullFilePath);
        if (!dist.getParentFile().exists()) {
            dist.getParentFile().mkdirs();
        }
        //上传
        file.transferTo(dist);
    }
}
