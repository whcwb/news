package com.cwb.biz.controller;

import com.cwb.biz.model.News;
import com.cwb.biz.service.NewsService;
import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsControl extends BaseController<News,String> {

    @Autowired
    private NewsService service;

    @Override
    protected BaseService<News, String> getBaseService() {
        return service;
    }
}
