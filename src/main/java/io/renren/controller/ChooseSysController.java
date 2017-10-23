package io.renren.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import io.renren.entity.ChooseSysEntity;
import io.renren.entity.MyMoneyEntity;
import io.renren.entity.ProjectEntity;
import io.renren.service.ChooseSysService;
import io.renren.service.MyMoneyService;
import io.renren.service.PersonService;
import io.renren.service.ProjectService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;
import io.renren.utils.ShiroUtils;


/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 22:17:04
 */
@Controller
@RequestMapping("choosesys")
public class ChooseSysController {
	@Autowired
	private ChooseSysService chooseSysService;
	
	@Autowired
	private MyMoneyService myMoneyService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/choosesys.html")
	public String list(){
		return "choosesys/choosesys.html";
	}
	
	@RequestMapping("/Mychoosesys.html")
	public String Mylist(){
		return "choosesys/Mychoosesys.html";
	}
	
	@RequestMapping("/choosesys_add.html")
	public String add(){
		return "choosesys/choosesys_add.html";
	}
	
	/**
	 * 家庭管理员查询 本家庭人员投资的项目列表
	 */
	@ResponseBody
	@RequestMapping("/listFamliy")
	public R listFamliy(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		map.put("userName", userName);//家庭管理员用户名
		//查询列表数据
		List<ChooseSysEntity> chooseSysList = chooseSysService.queryListByAdmin(map);
		for(int i=0;i<chooseSysList.size();i++){
			ChooseSysEntity obj = chooseSysList.get(i);
			ProjectEntity proObj = projectService.queryObject(Integer.parseInt(obj.getProName()));
			obj.setProName(proObj==null?null:proObj.getProName());
			obj.setUserName((personService.getName(obj.getUserName())));
		}
		int total = chooseSysList.size();//chooseSysService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(chooseSysList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 家庭人员 查询个人 投资项目列表
	 */
	@ResponseBody
	@RequestMapping("/myPersonlist")
	public R myPersonlist(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		map.put("userName", userName);
		//查询列表数据
		List<ChooseSysEntity> chooseSysList = chooseSysService.queryList(map);
		for(int i=0;i<chooseSysList.size();i++){
			ChooseSysEntity obj = chooseSysList.get(i);
			ProjectEntity proObj = projectService.queryObject(Integer.parseInt(obj.getProName()));
			obj.setProName(proObj==null?null:proObj.getProName());

		}
		int total = chooseSysService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(chooseSysList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		ChooseSysEntity chooseSys = chooseSysService.queryObject(id);
		
		return R.ok().put("chooseSys", chooseSys);
	}
	
	/**
	 * 家庭成员新增 投资项目 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public R save(@RequestBody ChooseSysEntity chooseSys){
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		MyMoneyEntity object = myMoneyService.queryObjectByName(userName);
		int myMoney = object.getMymoney();
		String money = chooseSys.getPutMoney();
		int outMoney = Integer.parseInt(money);
		if(myMoney>=outMoney){
			chooseSys.setInMoney("0");
			chooseSys.setUserName((userName));
			chooseSys.setChooseDate(new Date());
			chooseSysService.save(chooseSys);
			int leftMoney = myMoney-outMoney;
			object.setMymoney(leftMoney);
			myMoneyService.update(object);
			return R.ok();
		}else{
			return R.error("你资产余额不足！");
		}
		
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(@RequestBody ChooseSysEntity chooseSys){
		chooseSysService.update(chooseSys);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		for (int i = 0; i < ids.length; i++) {
			ChooseSysEntity obj = chooseSysService.queryObject(ids[i]);
			String userName = ShiroUtils.getSessionAttribute("username").toString();
			MyMoneyEntity moneyObj = myMoneyService.queryObjectByName(userName);
			moneyObj.setMymoney(Integer.parseInt(obj.getPutMoney()));
			myMoneyService.update(moneyObj);
		}
		chooseSysService.deleteBatch(ids);
		return R.ok();
	}
	
	
	/**
	 * 获取选取投资项目页面下拉列表数据
	 */
	@ResponseBody
	@RequestMapping("/getProject")
	public R getProject(){
		List<ProjectEntity> projectSysList = projectService.queryProjectList();
		List<Map<String,String>> projectSysListMap = new ArrayList<Map<String,String>>();
		for(ProjectEntity entity: projectSysList){
			Map<String,String> project =new HashMap<String,String>();
			project.put("projectId", entity.getId()+"");
			project.put("projectName", entity.getProName());
			projectSysListMap.add(project);
		}
		return R.ok().put("data", projectSysListMap);
	}
	
	
	
	
}
