package com.cwb.news.util.mapperprovider;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@tk.mybatis.mapper.annotation.RegisterMapper
public interface OracleInsertListMapper<T> {
	
	@Options(useGeneratedKeys = false, keyProperty = "id")
	@InsertProvider(type = OracleInsertListProvider.class, method = "dynamicSQL")
    int insertList(List<T> record);
}