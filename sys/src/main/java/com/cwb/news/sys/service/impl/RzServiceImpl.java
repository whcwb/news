package com.cwb.news.sys.service.impl;

import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.sys.base.LimitedCondition;
import com.cwb.news.sys.mapper.SysPtrzMapper;
import com.cwb.news.sys.model.SysRz;
import com.cwb.news.sys.service.RzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class RzServiceImpl extends BaseServiceImpl<SysRz,String> implements RzService {
    @Autowired
    private SysPtrzMapper entityMapper;

    @Override
    protected Mapper<SysRz> getBaseMapper() {
        return entityMapper;
    }

    @Override
    protected Class<?> getEntityCls(){
        return SysRz.class;
    }

    @Override
    public boolean fillPagerCondition(LimitedCondition condition){
        condition.setOrderByClause("czsj desc");
        return true;
    }
}
