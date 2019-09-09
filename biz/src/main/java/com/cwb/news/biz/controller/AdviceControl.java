package com.cwb.news.biz.controller;

import com.cwb.news.biz.model.Advice;
import com.cwb.news.biz.service.AdviceService;
import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advice")
public class AdviceControl extends BaseController<Advice,String>  {

    @Autowired
    private AdviceService adviceService;

    @Override
    protected BaseService<Advice, String> getBaseService() {
        return adviceService;
    }

    @PostMapping("/save")
    public ApiResponse<String> save(Advice entity){
        return adviceService.validAndSave(entity);
    }



}
