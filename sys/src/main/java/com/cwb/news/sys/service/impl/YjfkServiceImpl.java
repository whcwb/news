package com.cwb.news.sys.service.impl;

import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.sys.mapper.SysYjfkMapper;
import com.cwb.news.sys.model.SysYjfk;
import com.cwb.news.sys.service.YjfkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class YjfkServiceImpl extends BaseServiceImpl<SysYjfk,String> implements YjfkService {
    @Autowired
    private SysYjfkMapper yjfkMapper;
    @Override
    protected Mapper<SysYjfk> getBaseMapper() {
        return yjfkMapper;
    }
}
