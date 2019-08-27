package com.cwb.news.biz.service.impl;

import com.cwb.news.biz.cons.FileType;
import com.cwb.news.biz.mapper.VideoMapper;
import com.cwb.news.biz.model.Video;
import com.cwb.news.biz.service.VideoService;
import com.cwb.news.sys.base.BaseServiceImpl;
import com.cwb.news.sys.model.SysYh;
import com.cwb.news.util.bean.ApiResponse;
import com.cwb.news.util.commonUtil.FileConvertManager;
import com.cwb.news.util.exception.RuntimeCheck;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.common.Mapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;


@Service
public class VideoServiceImpl extends BaseServiceImpl<Video, String> implements VideoService {

	@Autowired
	private VideoMapper baseMapper;

	@Value("${mp4cacheimg}")
	private String mp4cacheimg;

	@Value("${staticPath}")
	private String staticPath;

	@Autowired
	private FileConvertManager convertManager;
	
	@Override
	protected Mapper<Video> getBaseMapper() {
		return baseMapper;
	}

    @Override
    public ApiResponse<String> uploadVideo(MultipartFile file) throws IOException {
		InputStream ins = file.getInputStream();
		String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		String filePath =  "/video/" + DateTime.now().toString("yyyyMMdd") + "/" + System.currentTimeMillis() + suffix;
		File mdd = new File(staticPath + filePath);
		FileUtils.copyInputStreamToFile(ins,mdd);
		// 替换视频目录
		mp4cacheimg.replace("@videofile",staticPath + filePath);
		String imgPath =  "/videoImg/" + DateTime.now().toString("yyyyMMdd")+ "/" + System.currentTimeMillis() + ".jpg";
		mp4cacheimg.replace("@cachefile",staticPath + imgPath);
		convertManager.convertMp4OrExtrPic(mp4cacheimg);

		return ApiResponse.success(filePath + "," + imgPath);
	}

	@Override
	public ApiResponse<String> validAndSave(Video entity){

		SysYh user = getCurrentUser();
		RuntimeCheck.ifBlank(entity.getViLang(), "视频语言类型不能为空");
		RuntimeCheck.ifBlank(entity.getViType(), "视频类型不能为空");
		RuntimeCheck.ifBlank(entity.getViPath(), "请上传视频");
		if(StringUtils.equals(entity.getViType(), FileType.ADVERST)){
			// 宣传片 只允许存在一个 先删掉一个
			baseMapper.deleteAd(entity.getViLang(),entity.getViType());
		}
		entity.setCjr(user.getXm());
		entity.setCjsj(DateTime.now().toString("yyyy-MM-dd HH:mm:ss"));
		entity.setId(genId());
		save(entity);
		return ApiResponse.saveSuccess();

	}

}