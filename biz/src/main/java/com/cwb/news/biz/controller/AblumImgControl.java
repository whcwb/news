package com.cwb.news.biz.controller;

import com.cwb.news.biz.model.AblumImg;
import com.cwb.news.biz.service.AblumImgService;
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
@RequestMapping("/api/ablumimg")
public class AblumImgControl extends BaseController<AblumImg,String> {

    @Autowired
    private AblumImgService service;

    @Override
    protected BaseService<AblumImg, String> getBaseService() {
        return service;
    }

    /**
     * 单个照片存储
     */
    @Override
    @PostMapping("/save")
    public ApiResponse<String> save(AblumImg entity){
        return service.validAndSave(entity);
    }

    /**
     * 多个照片存储到相册
     * imgList用 , 隔开
     */
    @PostMapping("/saveList")
    public ApiResponse<String> saveList(String abId, String imgList){
        return service.saveList(abId, imgList);
    }


}
