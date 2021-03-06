package com.cwb.news.sys.controller;

import com.cwb.news.sys.base.BaseController;
import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.bean.Menu;
import com.cwb.news.sys.model.SysFw;
import com.cwb.news.sys.model.SysGn;
import com.cwb.news.sys.model.SysYh;
import com.cwb.news.sys.service.GnService;
import com.cwb.news.util.bean.ApiResponse;
import com.cwb.news.util.commonUtil.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 平台功能
 */
@RestController
@RequestMapping("/api/gn")
public class GnController extends BaseController<SysGn, String> {
    @Autowired
    private GnService gnService;

    @Override
    protected BaseService<SysGn, String> getBaseService() {
        return gnService;
    }

    @Override
    @RequestMapping(value="/save", method={RequestMethod.POST})
    public ApiResponse<String> save(@Valid SysGn entity) {

        return gnService.saveEntity(entity);
    }

    @RequestMapping("initMenu")
    public ApiResponse<String> initMenu(String menus){
        List<Menu> menuList = JsonUtil.toList(menus,Menu.class);
        return gnService.initMenu(menuList);
    }


    @Override
    @RequestMapping(value="/update", method={RequestMethod.POST})
    public ApiResponse<String> update(@Valid  SysGn gn){
        return gnService.updateEntity(gn);
    }


    @RequestMapping(value = "getUserFunctions",method = RequestMethod.GET)
    public ApiResponse<List<SysGn>> getUserFunctions(){
        SysYh user = getCurrentUser();
        return ApiResponse.success(gnService.getUserFunctions(user));
    }


    @RequestMapping(value = "getMenuTree",method = RequestMethod.GET)
    public ApiResponse<List<Menu>> getMenuTree(){
        SysYh user = getCurrentUser();
        return ApiResponse.success(gnService.getMenuTree(user));
    }


    @RequestMapping("setRoleFunctions")
    public ApiResponse<String> setRoleFunctions(String jsdm,String gndms){
        List<String> gndmList = new ArrayList<>();
        if (StringUtils.isNotBlank(gndms)){
            gndmList = Arrays.asList(gndms.split(","));
        }
        return gnService.setRoleFunctions(jsdm,gndmList);
    }
    @RequestMapping("setOrgFunctions")
    public ApiResponse<String> setOrgFunctions(String jgdm,String gndms){
        List<String> gndmList = new ArrayList<>();
        if (StringUtils.isNotBlank(gndms)){
            gndmList = Arrays.asList(gndms.split(","));
        }
        return gnService.setOrgFunctions(jgdm,gndmList);
    }


    @RequestMapping("getOrgFunctions")
    public ApiResponse<List<SysGn>> getOrgFunctions(String jgdm){
        return ApiResponse.success(gnService.getOrgFunctions(jgdm));
    }


    @RequestMapping("getRoleFunctions")
    public ApiResponse<List<SysGn>> getRoleFunctions(String jsdm){
        return gnService.getRoleFunctions(jsdm);
    }



    @RequestMapping("getAllPermissionTree")
    public ApiResponse<List<SysFw>> getAllPermissionTree(){
        return ApiResponse.success(gnService.getAllPermissionTree());
    }


    @RequestMapping("getPermissionTreeWithChecked")
    public ApiResponse<List<SysGn>> getPermissionTreeWithChecked(@RequestParam(value = "parentCode",required = false) String parentCode,
                                                                 @RequestParam(value = "sonCode",required = false)String sonCode){
        List<SysGn> parentGnList = gnService.getOrgFunctions(parentCode);
        if (StringUtils.isNotEmpty(sonCode)){
            List<String> sonGndmList = gnService.getOrgFunctionCodes(sonCode);
            if (sonGndmList.size() != 0){
                for (SysGn gn : parentGnList) {
                    if (sonGndmList.contains(gn.getGndm())){
                        gn.setChecked("checked");
                    }
                }
            }
        }
        List<SysGn> functionTree = gnService.buildFunctionTree(parentGnList);
        return ApiResponse.success(functionTree);
    }

    @RequestMapping("getOrgPermissionTree")
    public ApiResponse<List<SysFw>> getOrgPermissionTree(String jgdm){
        if (StringUtils.isEmpty(jgdm)){
            SysYh user = getCurrentUser();
            jgdm = user.getJgdm();
        }
        return ApiResponse.success(gnService.getOrgPermissionTree(jgdm));
    }

    @RequestMapping("getCurrentOrgPermissionTree")
    public ApiResponse<List<SysFw>> getCurrentOrgPermissionTree(){
        SysYh user = getCurrentUser();
        String jgdm = user.getJgdm();
        return ApiResponse.success(gnService.getOrgPermissionTree(jgdm));
    }


    @RequestMapping("getUserPermissionTree")
    public ApiResponse<List<SysFw>> getUserPermissionTree(){
        SysYh user = getCurrentUser();
        return ApiResponse.success(gnService.getUserPermissionTree(user));
    }


    @RequestMapping("getRolePermissionTree")
    public ApiResponse<List<SysFw>> getRolePermissionTree(String jsdm){
        return ApiResponse.success(gnService.getRolePermissionTree(jsdm));
    }

    @Override
    @RequestMapping(value="/removeIds", method={RequestMethod.POST})
    public ApiResponse<String> remove(String[] ids){
        return gnService.removeByIds(ids);
    }


}
