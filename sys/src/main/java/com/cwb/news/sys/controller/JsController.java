package com.cwb.news.sys.controller;

import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.model.SysJs;
import com.cwb.news.sys.service.JsService;
import com.cwb.news.util.bean.ApiResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 平台角色
 */
@RestController
@RequestMapping("/api/js")
public class JsController extends BaseController<SysJs, String> {
    @Autowired
    private JsService roleService;

    @Override
    protected BaseService<SysJs, String> getBaseService() {
        return roleService;
    }

    @Override
    public ApiResponse<String> save(SysJs entity) {
        return roleService.saveEntity(entity);
    }
    
    @Override
    public ApiResponse<String> update(SysJs entity) {
        return roleService.updateEntity(entity);
    }

    /**
     * 修改用户角色
     * @param userId 用户id
     * @param roleIds 角色id列表
     * @return 操作结果
     */
    @RequestMapping(value = "modifyUserRoles",method = RequestMethod.POST)
    public ApiResponse<String> modifyUserRoles(@RequestParam(name="userId" ) String userId,
                                               @RequestParam(name="roleIds",required = false) String roleIds){
        if(StringUtils.isNotBlank(roleIds)){
            return roleService.modifyUserRoles(userId, Arrays.asList(roleIds.split(",")));
        }else{
            return roleService.modifyUserRoles(userId,new ArrayList<>());
        }

    }

    /**
     * 获取用户角色
     * @param userId 用户id
     * @return 操作结果
     */
    @RequestMapping(value = "getUserRoles")
    public ApiResponse<List<SysJs>> getUserRoles(String userId){
        List<SysJs> roles = roleService.getUserRoles(userId);
        return new ApiResponse<>(roles);
    }
    @RequestMapping(value = "getUserRolesWithChecked")
    public ApiResponse<List<SysJs>> getUserRolesWithChecked(String userId){
        List<SysJs> roles = roleService.getUserRolesWithChecked(userId);
        return new ApiResponse<>(roles);
    }
}
