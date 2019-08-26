package com.cwb.news.sys.controller;

import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.model.SysHdyx;
import com.cwb.news.sys.service.HdService;
import com.cwb.news.util.bean.ApiResponse;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 活动营销
 */
@RestController
@RequestMapping("/api/hd")
public class HdController extends BaseController<SysHdyx,String> {
    @Autowired
    private HdService service;


    @RequestMapping("add")
    public ApiResponse<String> add(SysHdyx entity){
        return service.saveEntity(entity);
    }

    @Override
    @RequestMapping("update")
    public ApiResponse<String> update(SysHdyx entity){
        return service.updateEntity(entity);
    }

    @RequestMapping("pager")
    public ApiResponse<List<SysHdyx>> pager(Page<SysHdyx> pager){
        return service.pager(pager);
    }


    @Override
    @RequestMapping(value="/save", method={RequestMethod.POST})
    public ApiResponse<String> save(SysHdyx entity) {
        return service.saveEntity(entity);
    }

    @Override
    protected HdService getBaseService() {
        return service;
    }
}
