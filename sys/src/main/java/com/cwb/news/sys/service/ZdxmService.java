package com.cwb.news.sys.service;

import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.model.SysZdxm;
import com.cwb.news.util.bean.ApiResponse;

import java.util.List;

/**
 * auther chenwei
 * create at 2018/2/27
 */
public interface ZdxmService extends BaseService<SysZdxm,String>{
    List<SysZdxm> findByTypeCode(String typeCode);
    List<SysZdxm> findByZdlms(List<String> zdlms);
    ApiResponse<String> add(SysZdxm zdxm);
}
