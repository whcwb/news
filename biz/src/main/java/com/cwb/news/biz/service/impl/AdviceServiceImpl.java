package com.cwb.news.biz.service.impl;

import com.cwb.news.biz.mapper.AdviceMapper;
import com.cwb.news.biz.model.Advice;
import com.cwb.news.biz.service.AdviceService;
import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class AdviceServiceImpl extends BaseServiceImpl<Advice,String>  implements AdviceService {
    @Autowired
    private AdviceMapper mapper;

    @Override
    protected Mapper<Advice> getBaseMapper() {
        return mapper;
    }

    @Override
    public ApiResponse<String> validAndSave(Advice entity){
        entity.setId(genId());
        save(entity);
        return ApiResponse.saveSuccess();
    }

}
