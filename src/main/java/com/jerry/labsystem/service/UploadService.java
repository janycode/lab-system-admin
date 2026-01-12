package com.jerry.labsystem.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
    void upload(MultipartFile file) throws IOException;
}
