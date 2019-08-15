package com.cwb.biz.service.impl;

import com.cwb.biz.mapper.NewsMapper;
import com.cwb.biz.model.News;
import com.cwb.biz.service.NewsService;
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
