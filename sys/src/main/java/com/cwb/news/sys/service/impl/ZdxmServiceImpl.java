package com.cwb.news.sys.service.impl;

import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.sys.mapper.SysZdlmMapper;
import com.cwb.news.sys.mapper.SysZdxmMapper;
import com.cwb.news.sys.model.SysZdlm;
import com.cwb.news.sys.model.SysZdxm;
import com.cwb.news.sys.service.ZdxmService;
import com.cwb.news.util.bean.ApiResponse;
import com.cwb.news.util.bean.SimpleCondition;
import com.cwb.news.util.commonUtil.DateUtils;
import com.cwb.news.util.exception.RuntimeCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * auther chenwei
 * create at 2018/2/27
 */
@Service
public class ZdxmServiceImpl extends BaseServiceImpl<SysZdxm,String> implements ZdxmService {
    @Autowired
    private SysZdxmMapper zdxmMapper;
    @Autowired
    private SysZdlmMapper zdlmMapper;
    @Override
    protected Mapper<SysZdxm> getBaseMapper() {
        return zdxmMapper;
    }

    @Override
    public List<SysZdxm> findByTypeCode(String typeCode) {
        SimpleCondition condition = new SimpleCondition(SysZdxm.class);
        condition.eq(SysZdxm.InnerColumn.zdlmdm,typeCode);
        condition.setOrderByClause( SysZdxm.InnerColumn.qz.asc());
        return zdxmMapper.selectByExample(condition);
    }

    @Override
    public List<SysZdxm> findByZdlms(List<String> zdlms) {
        if(zdlms==null||zdlms.size()==0){
            return new ArrayList<SysZdxm>();
        }
        SimpleCondition condition = new SimpleCondition(SysZdxm.class);
        condition.in(SysZdxm.InnerColumn.zdlmdm,zdlms);
        return zdxmMapper.selectByExample(condition);
    }

    @Override
    public ApiResponse<String> add(SysZdxm zdxm) {
        RuntimeCheck.ifBlank(zdxm.getZddm(),"字典代码不能为空");
        RuntimeCheck.ifBlank(zdxm.getZdlmdm(),"字典类目代码不能为空");
        RuntimeCheck.ifBlank(zdxm.getZdmc(),"字典名称不能为空");
        SysZdlm zdlm = zdlmMapper.selectByPrimaryKey(zdxm.getZdlmdm());
        RuntimeCheck.ifNull(zdlm,"未找到字典类目");

        SimpleCondition condition = new SimpleCondition(SysZdxm.class);
        condition.eq(SysZdxm.InnerColumn.zddm,zdxm.getZddm());
        condition.eq(SysZdxm.InnerColumn.zdlmdm,zdxm.getZdlmdm());
        int count = zdxmMapper.selectCountByExample(condition);
        RuntimeCheck.ifTrue(count != 0,"字典代码已存在");

        zdxm.setCjr(getOperateUser());
        zdxm.setCjsj(DateUtils.getNowTime());
        zdxm.setZdId(genId());
        zdxmMapper.insertSelective(zdxm);
        return ApiResponse.success();
    }

	
}
