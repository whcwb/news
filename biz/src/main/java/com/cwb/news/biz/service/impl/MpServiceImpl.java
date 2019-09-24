package com.cwb.news.biz.service.impl;

import com.cwb.news.biz.mapper.MpMapper;
import com.cwb.news.biz.model.Mp;
import com.cwb.news.biz.service.MpService;
import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.util.bean.ApiResponse;
import com.cwb.news.util.commonUtil.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
@Service
public class MpServiceImpl extends BaseServiceImpl<Mp,String> implements MpService {

    @Autowired
    private MpMapper baseMapper;
    @Override
    protected Mapper<Mp> getBaseMapper() {
        return baseMapper;
    }

    @Override
    public ApiResponse<String> validAndSave(Mp entity){
        entity.setId(genId());
        entity.setCjsj(DateUtils.getNowTime());
        save(entity);
        return ApiResponse.success();
    }



}
