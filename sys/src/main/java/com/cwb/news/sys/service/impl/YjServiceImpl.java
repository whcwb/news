package com.cwb.news.sys.service.impl;

import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.sys.mapper.SysYjfkMapper;
import com.cwb.news.sys.model.SysYjfk;
import com.cwb.news.sys.service.YjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author chenwei
 * @copyright
 * @category
 * @since 2018/2/26
 */
@Service
public class YjServiceImpl extends BaseServiceImpl<SysYjfk,String> implements YjService{
    @Autowired
    private SysYjfkMapper yjfkMapper;
    @Override
    protected Mapper<SysYjfk> getBaseMapper() {
        return yjfkMapper;
    }
}
