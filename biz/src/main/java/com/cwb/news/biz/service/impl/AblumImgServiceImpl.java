package com.cwb.news.biz.service.impl;

import com.cwb.news.biz.mapper.AblumImgMapper;
import com.cwb.news.biz.model.AblumImg;
import com.cwb.news.biz.service.AblumImgService;
import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.sys.model.SysYh;
import com.cwb.news.util.bean.ApiResponse;
import com.cwb.news.util.exception.RuntimeCheck;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class AblumImgServiceImpl extends BaseServiceImpl<AblumImg, String> implements AblumImgService {

	@Autowired
	private AblumImgMapper baseMapper;
	
	@Override
	protected Mapper<AblumImg> getBaseMapper() {
		return baseMapper;
	}

	@Override
	public ApiResponse<String> validAndSave(AblumImg entity){

		SysYh user = getCurrentUser();
		RuntimeCheck.ifBlank(entity.getAbId(), "请选择相册");
		RuntimeCheck.ifBlank(entity.getAbImg(), "请上传图片");
		entity.setId(genId());
		entity.setCjsj(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
		entity.setCjr(user.getXm());
		int i = save(entity);
		return i==1? ApiResponse.saveSuccess():ApiResponse.fail();

	}

	@Override
	public ApiResponse<String> saveList(String abId, String imgList) {
		RuntimeCheck.ifBlank(abId, "请选择相册");
		RuntimeCheck.ifBlank(imgList, "请上传图片");
		SysYh user = getCurrentUser();
		List<AblumImg>  imgs = new ArrayList<>();
		Arrays.asList(imgList.split(",")).forEach(s -> {
			AblumImg img = new AblumImg();
			img.setId(genId());
			img.setCjr(user.getXm());
			img.setCjsj(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
			img.setAbId(abId);
			img.setAbImg(s);
			imgs.add(img);
		});
		baseMapper.insertList(imgs);
		return ApiResponse.saveSuccess();
	}
}