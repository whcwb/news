package com.cwb.news.biz.controller;

import com.cwb.news.biz.model.Gl;
import com.cwb.news.biz.service.GlService;
import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/gl")
public class GlControl extends BaseController<Gl,String> {
    @Autowired
    private GlService glService;
    @Override
    protected BaseService<Gl, String> getBaseService() {
        return glService;
    }
}
