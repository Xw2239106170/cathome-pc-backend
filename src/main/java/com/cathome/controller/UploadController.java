package com.cathome.controller;

import com.aliyun.oss.model.MultipartUpload;
import com.cathome.pojo.Result;
import com.cathome.utils.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 文件上传接口
 */
@RestController
@CrossOrigin(origins = "*")
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    /**
     * 文件上传接口
     * @param image
     * @return
     * @throws IOException
     */
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        String url = aliOSSUtils.upload(image);
        return Result.success(url);
    }
}
