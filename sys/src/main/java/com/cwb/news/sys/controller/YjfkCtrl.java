package com.cwb.news.sys.controller;

import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.model.SysYjfk;
import com.cwb.news.sys.service.YjfkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/yjfk")
public class YjfkCtrl extends BaseController<SysYjfk,String> {

    @Autowired
    private YjfkService yjfkService;
    @Override
    protected BaseService<SysYjfk, String> getBaseService() {
        return yjfkService;
    }
}
