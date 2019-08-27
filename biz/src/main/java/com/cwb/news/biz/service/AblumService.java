package com.cwb.news.biz.service;


import com.cwb.news.biz.model.Ablum;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.util.bean.ApiResponse;

public interface AblumService extends BaseService<Ablum, String> {

    ApiResponse<String> removeAblum(String id);
}