package com.cwb.news.biz.controller;

import com.cwb.news.biz.model.Mp;
import com.cwb.news.biz.service.MpService;
import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mp")
public class MpController extends BaseController<Mp,String> {

    @Autowired
    private MpService service;

    @Override
    protected BaseService<Mp, String> getBaseService() {
        return service;
    }
}
