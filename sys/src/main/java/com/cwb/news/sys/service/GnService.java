package com.cwb.news.sys.service;

import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.bean.Menu;
import com.cwb.news.sys.model.SysFw;
import com.cwb.news.sys.model.SysGn;
import com.cwb.news.sys.model.SysYh;
import com.cwb.news.util.bean.ApiResponse;

import java.util.List;

public interface GnService extends BaseService<SysGn, String> {
    ApiResponse<String> saveEntity(SysGn entity);

    void cachePermission(List<String> ids);

    List<SysGn> buildFunctionTree(List<SysGn> functionList);

    /**
     * 查找某个服务的所有功能
     * @param serviceCode 服务代码
     * @return 功能列表
     */
    List<SysGn> findByServiceCode(String serviceCode);


    /**
     * 设置机构功能
     * @param orgCode 机构代码
     * @param functionCode 功能代码
     * @return 执行结果
     */
    ApiResponse<String> setOrgFunction(String orgCode, List<String> functionCode);

    /**
     * 查询机构拥有的功能列表
     * @param gndm 机构代码
     * @return 功能列表
     */
    List<SysGn> findByGndm(String gndm);

    List<SysGn> getUserFunctions(SysYh user);
    List<SysGn> getOrgFunctions(String orgCode);

    List<String> getUserFunctionCodes(SysYh user);
    List<String> getOrgFunctionCodes(String orgCode);

    List<SysGn> getRolesFunctions(List<String> jsdms);
    List<String> getRolesFunctionCodes(List<String> jsdms);

    List<SysFw> getAllPermissionTree();

    List<SysFw> getOrgPermissionTree(String jgdm);

    List<SysFw> getUserPermissionTree(SysYh user);
    List<SysFw> getRolePermissionTree(String jsdm);

    ApiResponse<String> updateEntity(SysGn gn);

    ApiResponse<String> setRoleFunctions(String jsdm, List<String> gndms);

    ApiResponse<List<SysGn>> getRoleFunctions(String jsdm);

    List<Menu> getMenuTree(SysYh user);

    ApiResponse<String> initMenu(List<Menu> menus);

    ApiResponse<String> setOrgFunctions(String jgdm, List<String> gndmList);
    /**
     * 加载所有角色的权限
     */
    void initPermission();

    ApiResponse<String> removeByIds(String[] ids);
}
