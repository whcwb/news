package com.cwb.news.biz.controller;

import com.cwb.news.biz.model.Video;
import com.cwb.news.biz.service.VideoService;
import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author slu
 */
@RestController
@RequestMapping("/api/video")
public class VideoControl extends BaseController<Video,String> {

    @Autowired
    private VideoService service;

    @Override
    protected BaseService<Video, String> getBaseService() {
        return service;
    }

    @Override
    @PostMapping("/save")
    public ApiResponse<String> save(Video entity){
        return service.validAndSave(entity);
    }



}
