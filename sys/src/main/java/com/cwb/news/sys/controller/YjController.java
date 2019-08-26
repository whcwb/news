package com.cwb.news.sys.controller;

import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.model.SysYjfk;
import com.cwb.news.sys.service.YjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 意见
 */
@RestController
@RequestMapping("/api/yj")
public class YjController extends BaseController<SysYjfk,String>{
    @Autowired
    private YjService service;

    @Override
    protected BaseService<SysYjfk, String> getBaseService() {
        return service;
    }
}
