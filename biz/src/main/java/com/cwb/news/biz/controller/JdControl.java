package com.cwb.news.biz.controller;

import com.cwb.news.biz.model.Jd;
import com.cwb.news.biz.service.JdService;
import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jd")
public class JdControl extends BaseController<Jd,String> {
    @Autowired
    private JdService service;

    @Override
    protected BaseService<Jd, String> getBaseService() {
        return service;
    }

    @PostMapping("/save")
    public ApiResponse<String> save(Jd entity){
        return service.validAndSave(entity);
    }


}
