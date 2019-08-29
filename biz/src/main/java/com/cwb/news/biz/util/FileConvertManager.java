package com.cwb.news.biz.util;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * 文件转换类
 * @author admins
 *
 */
@Component
public class FileConvertManager {
	private static final Logger logger = LoggerFactory.getLogger(FileConvertManager.class);
//	@Autowired
//	private Executor executor;

	private ExecutorService executor = Executors.newSingleThreadExecutor();

	/**
	 * 一个简单的通过命令行转换文件的方法
	 * @param cmd
	 */
	public void convertMp4OrExtrPic(String cmd){
		logger.info(cmd);
		if(StringUtils.isNotBlank(cmd)){
			logger.info("开启线程执行----");
			executor.execute(new ThreedTsConvertMp4OrExtrPic(cmd));
		}
	}
	
	
	/**
	 * ts转换mp4 以及视屏抽取图片的线程
	 * @author admins
	 *
	 */
	class ThreedTsConvertMp4OrExtrPic implements Runnable{
		String cmdStr = "";
		public ThreedTsConvertMp4OrExtrPic(){
			
		}
		public ThreedTsConvertMp4OrExtrPic(String cmd){
			cmdStr = cmd;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			BufferedReader br = null;
			 try {  
				 logger.info("线程执行命令------"+cmdStr); 
		            Process p = Runtime.getRuntime().exec(cmdStr); 
		            br = new BufferedReader(new InputStreamReader(p.getInputStream(), StandardCharsets.UTF_8));
		            String line = null;  
		            StringBuilder sb = new StringBuilder("");
		            while ((line = br.readLine()) != null) {
		                sb.append(line).append("\n");
		            }
			 }catch (Exception e) {  
		            e.printStackTrace(); 
		            logger.error("exeCmd error:"+e);
		        }
		        finally  
		        {  
		            if (br != null)  
		            {  
		                try {  
		                    br.close();  
		                } catch (Exception e) {  
		                    e.printStackTrace();  
		                }  
		            }
		           
		        } 
			
		}
		
	}
	
}
