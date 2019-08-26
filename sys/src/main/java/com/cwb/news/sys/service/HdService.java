package com.cwb.news.sys.service;

import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.model.SysHdyx;
import com.cwb.news.util.bean.ApiResponse;

/**
 * @author chenwei
 * @since 2018/2/26
 */
public interface HdService extends BaseService<SysHdyx,String> {
    /**
     * 新增活动
     * @param entity 参数
     * @return 操作结果
     */
    ApiResponse<String> saveEntity(SysHdyx entity);

    /**
     * 编辑活动
     * @param entity 参数
     * @return 操作结果
     */
    ApiResponse<String> updateEntity(SysHdyx entity);
}
