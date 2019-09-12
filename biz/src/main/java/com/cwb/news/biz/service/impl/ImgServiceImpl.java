package com.cwb.news.biz.service.impl;

import com.cwb.news.biz.mapper.ImgMapper;
import com.cwb.news.biz.model.Img;
import com.cwb.news.biz.service.ImgService;
import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.util.bean.ApiResponse;
import com.cwb.news.util.commonUtil.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

@Service
public class ImgServiceImpl extends BaseServiceImpl<Img,String> implements ImgService {

    @Autowired
    private ImgMapper mapper;
    @Override
    protected Mapper<Img> getBaseMapper() {
        return mapper;
    }

    public ApiResponse<String> validAndSave(Img img){
        img.setId(genId());
        img.setCjsj(DateUtils.getNowTime());
        save(img);
        return ApiResponse.success();
    }

}
