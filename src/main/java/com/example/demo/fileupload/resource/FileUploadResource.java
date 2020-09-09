package com.example.demo.fileupload.resource;

import com.example.demo.fileupload.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
public class FileUploadResource {

    @Autowired
    private FileUploadService fileUploadService;

    @PostMapping("/upload-file")
    public ResponseEntity<ResponseObject> uploadFile(@RequestParam("files") List<MultipartFile> multipartFileList){
        fileUploadService.upload(multipartFileList);
        ResponseObject resp = ResponseObject
                .builder()
                .responseMessage("The File uploaded successfully")
                .build();
        return ResponseEntity
                .ok()
                .body(resp);
    }

}
