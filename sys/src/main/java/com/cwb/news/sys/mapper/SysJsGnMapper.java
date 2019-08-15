package com.cwb.news.sys.mapper;

import com.cwb.news.sys.model.SysJsGn;
import com.cwb.news.util.cache.MybatisRedisCache;
import com.cwb.news.util.mapperprovider.OracleInsertListMapper;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.cache.decorators.FifoCache;
import tk.mybatis.mapper.common.Mapper;

@CacheNamespace(implementation=MybatisRedisCache.class, eviction=FifoCache.class)
public interface SysJsGnMapper extends Mapper<SysJsGn>,OracleInsertListMapper<SysJsGn> {
}