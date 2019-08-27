package com.cwb.news.biz.controller;

import com.cwb.news.biz.service.VideoService;
import com.cwb.news.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class FileControl {

    @Autowired
    private VideoService service;



    /**
     * 视频上传
     * @param file
     * @throws IOException
     */
    @PostMapping("/uploadVideo")
    public ApiResponse<String> uploadVideo(@RequestParam("file") MultipartFile file) throws IOException {
        return service.uploadVideo(file);
    }



}
