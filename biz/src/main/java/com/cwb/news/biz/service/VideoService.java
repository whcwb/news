package com.cwb.news.biz.service;


import com.cwb.news.biz.model.Video;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.util.bean.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface VideoService extends BaseService<Video, String> {

    ApiResponse<String> uploadVideo(MultipartFile file) throws IOException;
}