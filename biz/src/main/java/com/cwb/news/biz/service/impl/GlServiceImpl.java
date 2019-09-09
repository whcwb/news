package com.cwb.news.biz.service.impl;

import com.cwb.news.biz.mapper.GlMapper;
import com.cwb.news.biz.model.Gl;
import com.cwb.news.biz.service.GlService;
import com.cwb.news.sys.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class GlServiceImpl extends BaseServiceImpl<Gl,String> implements GlService {

    @Autowired
    private GlMapper glMapper;

    @Override
    protected Mapper<Gl> getBaseMapper() {
        return glMapper;
    }
}
