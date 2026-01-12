package com.jerry.labsystem.controller;

import com.jerry.labsystem.service.UploadService;
import com.jerry.labsystem.utils.ResultObj;
import com.jerry.labsystem.utils.SysConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/admin/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping
    public ResultObj upload(@RequestParam("file") MultipartFile file) {
        try {
            uploadService.upload(file);
            return new ResultObj(SysConstant.CODE_SUCCESS, "上传成功");
        } catch (IOException e) {
            return new ResultObj(SysConstant.CODE_ERROR, "上传失败");
        }
    }
}
