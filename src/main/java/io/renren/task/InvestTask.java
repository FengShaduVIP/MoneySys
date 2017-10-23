package io.renren.task;

import java.util.Date;
import java.util.List;

import io.renren.entity.ChooseSysEntity;
import io.renren.entity.ProjectEntity;
import io.renren.service.ChooseSysService;
import io.renren.service.MyMoneyService;
import io.renren.service.ProjectService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 投资项目分红 定时任务
 * @author Mi amor
 *
 */
@Component("InvestTask")
public class InvestTask {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ChooseSysService chooseSysService;
	@Autowired
	private MyMoneyService myMoneyService;
	
	/**
	 * 单个投资项目
	 * 根据项目ID 分红
	 * @param params 投资项目id
	 */
	public void project(String params){
		log.info(" 时间："+new Date()+" ,单个项目分红任务开始。");
		log.info("传来参数为："+params);
		ProjectEntity projectObj =  projectService.queryObjectByNo(params);
		log.info("项目编号："+params+" "+projectObj.getProName()+" 投资项目开始分红。");
		List<ChooseSysEntity> chooseProjectList =  chooseSysService.getProjectList();
		for(int i=0;i<chooseProjectList.size();i++){
			ChooseSysEntity listObj = chooseProjectList.get(i);
			if(listObj.getProNo().equals(params)){
				String inMoney = projectObj.getInCash();
				String money = listObj.getInMoney();
				listObj.setInMoney(Integer.parseInt(money)+Integer.parseInt(inMoney)+"");
				chooseSysService.update(listObj);
				myMoneyService.updateMymoney(listObj.getUserName(),Integer.parseInt(inMoney));
				log.info("用户名为："+listObj.getUserName()+" 分红成功。分红金额："+inMoney+" 元");
			}
		}
	}
	
	/**
	 * 所有投资项目分红
	 */
	public void allProject(){
		log.info(" 时间："+new Date()+" ,所有投资项目分红任务开始。");
		List<ProjectEntity> projectList =  projectService.queryProjectList();
		for(ProjectEntity projectObj :projectList){
			log.info("项目编号："+projectObj.getProNo()+" "+projectObj.getProName()+" 投资项目开始分红。");
			List<ChooseSysEntity> chooseProjectList =  chooseSysService.getProjectList();
			for(int i=0;i<chooseProjectList.size();i++){
				ChooseSysEntity listObj = chooseProjectList.get(i);
				if(listObj.getProNo().equals(projectObj.getProNo())){
					String inMoney = projectObj.getInCash();
					String money = listObj.getInMoney();
					listObj.setInMoney(Integer.parseInt(money)+Integer.parseInt(inMoney)+"");
					chooseSysService.update(listObj);
					myMoneyService.updateMymoney(listObj.getUserName(),Integer.parseInt(inMoney));
					log.info("用户名为："+listObj.getUserName()+" 分红成功。分红金额："+inMoney+" 元");
				}
			}
		}
	}
	
}
