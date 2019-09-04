package com.cwb.news.biz.service.impl;

import com.cwb.news.biz.mapper.AblumMapper;
import com.cwb.news.biz.model.Ablum;
import com.cwb.news.biz.model.AblumImg;
import com.cwb.news.biz.service.AblumService;
import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.sys.model.SysYh;
import com.cwb.news.util.bean.ApiResponse;
import com.cwb.news.util.exception.RuntimeCheck;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections4.CollectionUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class AblumServiceImpl extends BaseServiceImpl<Ablum, String> implements AblumService {

	@Autowired
	private AblumMapper baseMapper;

	@Override
	protected Mapper<Ablum> getBaseMapper() {
		return baseMapper;
	}

	@Override
	public void afterPager(PageInfo<Ablum> result){
		List<Ablum> list = result.getList();
		if(CollectionUtils.isEmpty(list)){
			return;
		}
		Set<String> collect = list.stream().map(Ablum::getId).collect(Collectors.toSet());
		// 取相册中的最近的一张照片
		if(CollectionUtils.isNotEmpty(collect)){
			List<AblumImg> ablumImgs = baseMapper.latestImg(collect);
			Map<String, AblumImg> imgMap = ablumImgs.stream().collect(Collectors.toMap(AblumImg::getAbId, p -> p));
			list.forEach(ablum -> ablum.setAblumImg(imgMap.get(ablum.getId())));
		}
	}

	@Override
	public ApiResponse<String> validAndSave(Ablum entity){
		SysYh user = getCurrentUser();
		RuntimeCheck.ifBlank(entity.getAbName(), "相册名称不能为空");
		entity.setId(genId());
		entity.setCjr(user.getXm());
		entity.setCjsj(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
		int i = save(entity);
		return i==1?ApiResponse.saveSuccess():ApiResponse.fail();
	}


	@Override
	public ApiResponse<String> removeAblum(String id) {
		remove(id);
		baseMapper.removeImgs(id);
		return ApiResponse.success();
	}
}