package com.cwb.news.biz.mapper;

import com.cwb.news.biz.model.Ablum;
import com.cwb.news.biz.model.AblumImg;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Set;


public interface AblumMapper extends Mapper<Ablum> {

    @Select(" <script>select * from biz_ablum_img where ab_id in (select max(id) from biz_ablum_img " +
            "where ab_id in " +
            "<foreach collection='ids' index='index' item='item' " +
            "            open='(' separator=',' close=')'>" +
            "#{item} " +
            "</foreach>" +
            " group by ab_id ) </script>")
    List<AblumImg> latestImg(@Param("ids") Set<String> ids);

    @Delete(" delete from biz_ablum_img where ab_id = #{id}")
    void removeImgs(@Param("id")String id);

}