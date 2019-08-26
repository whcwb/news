package com.cwb.news.sys.service;

import com.cwb.news.sys.base.BaseService;
import com.cwb.news.sys.model.SysMessage;

/**
 * Created by Administrator on 2018/5/10.
 */
public interface SysMessageService extends BaseService<SysMessage,String> {
    void sendMessage(SysMessage sysMessage, String openId, String phone);

//    ApiResponse<String> repeatSendMessage(SysMessage entity);

    void nowSendMessage(String toString);

    void expireMessage(String toString);
}
