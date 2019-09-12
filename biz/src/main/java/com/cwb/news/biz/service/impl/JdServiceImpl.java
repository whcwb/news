package com.cwb.news.biz.service.impl;

import com.cwb.news.biz.mapper.JdMapper;
import com.cwb.news.biz.model.Jd;
import com.cwb.news.biz.service.JdService;
import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.util.bean.ApiResponse;
import com.cwb.news.util.commonUtil.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class JdServiceImpl extends BaseServiceImpl<Jd,String> implements JdService {

    @Autowired
    private JdMapper mapper;

    @Override
    protected Mapper<Jd> getBaseMapper() {
        return mapper;
    }
    @Override
    public ApiResponse<String> validAndSave(Jd entity){
        entity.setId(genId());
        entity.setCjsj(DateUtils.getNowTime());
        save(entity);
        return ApiResponse.success();
    }

}
