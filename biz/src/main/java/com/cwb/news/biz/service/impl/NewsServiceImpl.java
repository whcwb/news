package com.cwb.news.biz.service.impl;

import com.cwb.news.biz.mapper.NewsMapper;
import com.cwb.news.biz.model.News;
import com.cwb.news.biz.service.NewsService;
import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.util.bean.ApiResponse;
import com.cwb.news.util.commonUtil.DateUtils;
import com.cwb.news.util.exception.RuntimeCheck;
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

    @Override
    public ApiResponse<String> validAndSave(News en){
        RuntimeCheck.ifBlank(en.getTitle(), "新闻标题不能为空");
        RuntimeCheck.ifBlank(en.getContent(), "新闻内容不能为空");
        RuntimeCheck.ifBlank(en.getType(), "新闻类型不能为空");
        en.setId(genId());
        en.setCjsj(DateUtils.getNowTime());
        save(en);
        return ApiResponse.success();
    }


}
