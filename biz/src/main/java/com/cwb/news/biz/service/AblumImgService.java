package com.cwb.news.biz.service;


import com.cwb.news.biz.model.AblumImg;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.util.bean.ApiResponse;

public interface AblumImgService extends BaseService<AblumImg, String> {

    ApiResponse<String> saveList(String abId, String imgList);
}