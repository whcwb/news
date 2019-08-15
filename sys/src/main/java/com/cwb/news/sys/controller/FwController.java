package com.cwb.news.sys.controller;

import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.model.SysFw;
import com.cwb.news.sys.service.FwService;
import com.cwb.news.util.bean.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 平台服务
 */
@RestController
@RequestMapping("/api/fw")
public class FwController extends BaseController<SysFw, String> {
    @Autowired
    private FwService bizService;

    @Override
    protected BaseService<SysFw, String> getBaseService() {
        return bizService;
    }


    @Override
    public ApiResponse<String> save(SysFw entity) {
        return bizService.saveEntity(entity);
    }
    
    @RequestMapping(value="/update", method={RequestMethod.POST})
   	public ApiResponse<String> update(SysFw entity){
    	
   		return bizService.updateEntity(entity);
   	}
}
