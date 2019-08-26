package com.cwb.news.sys.controller;

import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.model.SysHsgs;
import com.cwb.news.sys.service.SysHsgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hsgs")
public class SysHsgsCtrl extends BaseController<SysHsgs, String> {
    @Autowired
    private SysHsgsService hsgsservice;
	
	@Override
	protected BaseService<SysHsgs, String> getBaseService() {
		return hsgsservice;
	}

}
