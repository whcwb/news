package com.cwb.news.biz.service.impl;

import com.cwb.news.biz.mapper.BannerMapper;
import com.cwb.news.biz.model.Banner;
import com.cwb.news.biz.service.BannerService;
import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.sys.model.SysYh;
import com.cwb.news.util.bean.ApiResponse;
import com.cwb.news.util.exception.RuntimeCheck;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;


@Service
public class BannerServiceImpl extends BaseServiceImpl<Banner, String> implements BannerService {

	@Autowired
	private BannerMapper baseMapper;
	
	@Override
	protected Mapper<Banner> getBaseMapper() {
		return baseMapper;
	}

	public static void main(String[] args) {
	}

	@Override
	public ApiResponse<String> validAndSave(Banner entity){
		RuntimeCheck.ifBlank(entity.getBanImg(), "请上传banner图");
		RuntimeCheck.ifBlank(entity.getBanName(), "请输入banner名称");
		RuntimeCheck.ifBlank(entity.getBanSize(), "请输入banner图大小");
		RuntimeCheck.ifBlank(entity.getBanType(), "请输入banner图类型");
		RuntimeCheck.ifTrue(entity.getBanSort() <= 0, "请填写排序");
		SysYh user = getCurrentUser();
		entity.setCjr(user.getXm());
		entity.setCjsj(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
		entity.setId(genId());
		save(entity);
		return ApiResponse.saveSuccess();

	}

	@Override
	public ApiResponse<String> updateSort(String id, int px) {
		RuntimeCheck.ifBlank(id,"请选择banner");
		Banner banner = findById(id);
		// 更新当前banner及往后的所有banner



		return null;
	}
}