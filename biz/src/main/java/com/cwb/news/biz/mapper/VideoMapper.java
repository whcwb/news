package com.cwb.news.biz.mapper;

import com.cwb.news.biz.model.Video;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface VideoMapper extends Mapper<Video> {

    /**
     * 删除宣传片
     * @param viLang
     * @param viType
     */
    @Delete(" delete from biz_video where vi_lang = #{viLang} and vi_type = #{viType}")
    void deleteAd(@Param("viLang") String viLang,@Param("viType") String viType);


}