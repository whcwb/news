package com.cwb.news.biz.controller;

import com.cwb.news.biz.model.Ablum;
import com.cwb.news.biz.service.AblumService;
import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author slu
 */
@RestController
@RequestMapping("/api/ablum")
public class AblumControl extends BaseController<Ablum,String> {

    @Autowired
    private AblumService service;

    @Override
    protected BaseService<Ablum, String> getBaseService() {
        return service;
    }

    /**
     * 相册新增
     */
    @Override
    @PostMapping("/save")
    public ApiResponse<String> save(Ablum entity){
        return service.validAndSave(entity);
    }

    /**
     * 相册删除  同时需要删除照片
     */
    @Override
    @RequestMapping("/remove/{pkid}")
    public ApiResponse<String> remove(@PathVariable("pkid") String id){
        return service.removeAblum(id);
    }

}
