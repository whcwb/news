package com.cwb.news.biz.controller;

import com.cwb.news.biz.model.News;
import com.cwb.news.biz.service.NewsService;
import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author slu
 */
@RestController
@RequestMapping("/api/news")
public class NewsControl extends BaseController<News,String> {

    @Autowired
    private NewsService service;

    @Override
    protected BaseService<News, String> getBaseService() {
        return service;
    }
}
