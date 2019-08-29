package com.cwb.news.biz.controller;

import com.cwb.news.biz.model.Banner;
import com.cwb.news.biz.service.BannerService;
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
@RequestMapping("/api/banner")
public class BannerControl extends BaseController<Banner,String> {
    @Autowired
    private BannerService service;

    @Override
    protected BaseService<Banner, String> getBaseService() {
        return service;
    }


    @Override
    @PostMapping("/save")
    public ApiResponse<String> save(Banner entity){
        return service.validAndSave(entity);
    }

    @PostMapping("/updateSort")
    public ApiResponse<String> updateSort(String id, int px){
        return service.updateSort(id,px);
    }

}
