package com.cwb.news.biz.controller;

import com.cwb.news.biz.model.Img;
import com.cwb.news.biz.service.ImgService;
import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/img")
public class ImgController extends BaseController<Img,String> {

    @Autowired
    private ImgService service;
    @Override
    protected BaseService<Img, String> getBaseService() {
        return service;
    }
    @PostMapping("/save")
    public ApiResponse<String> save(Img en){
        return service.validAndSave(en);
    }

}
