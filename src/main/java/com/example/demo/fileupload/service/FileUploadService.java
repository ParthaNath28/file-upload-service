package com.example.demo.fileupload.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileUploadService {

    public void upload(List<MultipartFile> multipartFileList){

        try {
            for (MultipartFile file : multipartFileList){
                file.transferTo(new File("E:\\Partha_Drive\\file_upload_demo\\"+file.getOriginalFilename()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
