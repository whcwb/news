package com.cwb.news.sys.base;

import com.cwb.news.util.bean.SimpleCondition;
import com.cwb.news.util.exception.RuntimeCheck;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author chenwei
 * @copyright
 * @category
 * @since 2018/2/8
 */
public class LimitedCondition extends SimpleCondition {

    /**
     * 有些对象在查询的时候并不需要做机构权限处理   BizCarGas "CoachValuation","ComplainRecord",  BizCarAnnualExam
     */
    private static final List<String> excludeEntityName = Arrays.asList(
            "SysZdxm","SysMessage","SysGn","SysYjfk","SysRz","SysHsgs","SysZdlm","Banner","News","Video","Ablum","AblumImg", "Jd");
    private static final List<String> jgdmsList = Arrays.asList("TraineeInformation","CoachManagement");
    public LimitedCondition(Class<?> entityClass) {
        super(entityClass);
        if (excludeEntityName.contains(entityClass.getSimpleName())) {
            return;
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String orgCode = (String) request.getAttribute("orgCode");

        if(jgdmsList.contains(entityClass.getSimpleName())){
            String orgCodes = (String) request.getAttribute("orgCodes");
            if(StringUtils.isNotBlank(orgCodes)){
                List<String> list = Arrays.asList(orgCodes.split(","));
                String condi = "";
                for (String s : list) {
                    if(StringUtils.isNotEmpty(condi)) {
                        condi += " or jgdm like '" + s + "%'";
                    }else{
                        condi += " jgdm like '" + s + "%'";
                    }
                }
                if(StringUtils.isNotBlank(orgCode)) {
                    condi += " or jgdm like '" + orgCode + "%'";
                }
                this.and().andCondition(condi);
            }else{
                RuntimeCheck.ifBlank(orgCode,"未找到机构");
                this.and().andLike("jgdm",orgCode+"%");
            }
        }else{

            RuntimeCheck.ifBlank(orgCode,"未找到机构");
            this.and().andLike("jgdm",orgCode+"%");
        }


    }
}
