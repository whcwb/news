package com.cwb.news.biz.service;


import com.cwb.news.biz.model.Banner;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.util.bean.ApiResponse;

public interface BannerService extends BaseService<Banner, String> {

    ApiResponse<String> updateSort(String id, int px);
}