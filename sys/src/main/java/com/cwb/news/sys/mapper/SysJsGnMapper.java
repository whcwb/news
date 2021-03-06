package com.cwb.news.sys.mapper;

import com.cwb.news.sys.model.SysJsGn;
import com.cwb.news.util.mapperprovider.InsertListMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

// @CacheNamespace(implementation=MybatisRedisCache.class, eviction=FifoCache.class)
public interface SysJsGnMapper extends Mapper<SysJsGn>, InsertListMapper<SysJsGn> {
    @Select(" Select JSDM from SYS_JS_GN where GNDM = #{gndm}")
    List<String> findJsIdsByGndm(@Param("gndm") String gndm);

}
