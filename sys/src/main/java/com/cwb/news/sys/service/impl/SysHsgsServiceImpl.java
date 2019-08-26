package com.cwb.news.sys.service.impl;

import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.sys.mapper.SysHsgsMapper;
import com.cwb.news.sys.model.SysHsgs;
import com.cwb.news.sys.service.SysHsgsService;
import com.cwb.news.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;

@Service
public class SysHsgsServiceImpl extends BaseServiceImpl<SysHsgs,String> implements SysHsgsService{
    @Autowired
    private SysHsgsMapper hsgsmapper;
  
	@Override
	protected Mapper<SysHsgs> getBaseMapper() {
		return hsgsmapper;
	}

	 @Override
	    public ApiResponse<String> validAndSave(SysHsgs e){
	        e.setId(genId());
	        e.setCjr(getOperateUser());
	        e.setCjsj(new Date());
	        save(e);
	        return ApiResponse.success();
	    }

	    @Override
	    public ApiResponse<String> validAndUpdate(SysHsgs e){
	        update(e);
	        return ApiResponse.success();
	    }
}
