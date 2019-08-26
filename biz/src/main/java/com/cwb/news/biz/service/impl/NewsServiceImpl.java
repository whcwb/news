package com.cwb.news.biz.service.impl;

import com.cwb.news.biz.mapper.NewsMapper;
import com.cwb.news.biz.model.News;
import com.cwb.news.biz.service.NewsService;
import com.cwb.news.sys.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class NewsServiceImpl extends BaseServiceImpl<News,String> implements NewsService {

    @Autowired
    private NewsMapper entityMapper;

    @Override
    protected Mapper<News> getBaseMapper() {
        return entityMapper;
    }


}
