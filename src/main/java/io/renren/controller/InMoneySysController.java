package io.renren.controller;

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

import io.renren.entity.InMoneySysEntity;
import io.renren.entity.MyMoneyEntity;
import io.renren.entity.PersonEntity;
import io.renren.service.InMoneySysService;
import io.renren.service.MyMoneyService;
import io.renren.service.PersonService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;
import io.renren.utils.ShiroUtils;


/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 19:39:32
 */
@Controller
@RequestMapping("inmoneysys")
public class InMoneySysController {
	@Autowired
	private InMoneySysService inMoneySysService;
	
	@Autowired
	private MyMoneyService myMoneyService;
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/inmoneysys.html")
	public String list(){
		return "inmoneysys/inmoneysys.html";
	}
	
	@RequestMapping("/inmoneysys_add.html")
	public String add(){
		return "inmoneysys/inmoneysys_add.html";
	}
	
	@RequestMapping("/lookmoney.html")
	public String listByUser(){
		return "inmoneysys/lookmoney.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		map.put("userName", userName);
		//查询列表数据
		List<InMoneySysEntity> inMoneySysList = inMoneySysService.queryList(map);
		int total = inMoneySysService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(inMoneySysList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	

	/**
	 * 列表 家庭成员收支列表
	 */
	@ResponseBody
	@RequestMapping("/listfamliy")
	public R listfamliy(Integer page, Integer limit){
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<InMoneySysEntity> inMoneySysList = inMoneySysService.queryListFamliy(map);
		//int total = inMoneySysService.queryTotal(map);
		for(int i=0;i<inMoneySysList.size();i++){
			InMoneySysEntity entity = inMoneySysList.get(i);
			PersonEntity personObj = personService.getFamliyCode(entity.getUserName());
			String name ="00";
			if(personObj!=null){
				name = personObj.getFamilyCode();
			}
			if(name.equals(userName)){
			}else{
				inMoneySysList.remove(entity);
			}
		}
		
		PageUtils pageUtil = new PageUtils(inMoneySysList, inMoneySysList.size(), limit, page);
		
		return R.ok().put("page", pageUtil);
	}
		
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/listOut")
	public R listOut(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		map.put("status", '1');
		//查询列表数据
		List<InMoneySysEntity> inMoneySysList = inMoneySysService.queryListOut(map);
		int total = inMoneySysService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(inMoneySysList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		InMoneySysEntity inMoneySys = inMoneySysService.queryObject(id);
		
		return R.ok().put("inMoneySys", inMoneySys);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public R save(@RequestBody InMoneySysEntity inMoneySys){
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		
		//判断 是否支出 还是收入
		int status = inMoneySys.getStatus();
		MyMoneyEntity myMoney = myMoneyService.queryObjectByName(userName);
		if(status==0){//收入
			int totalMoney =Integer.parseInt(inMoneySys.getInMoney()) + myMoney.getMymoney();
			myMoney.setMymoney(totalMoney);
			myMoneyService.update(myMoney);
		}else{
			int totalMoney =myMoney.getMymoney() - Integer.parseInt(inMoneySys.getInMoney());
			myMoney.setMymoney(totalMoney);
			myMoneyService.update(myMoney);
		}
		
		inMoneySys.setUserName(userName);
		inMoneySys.setUserId(personService.getName(userName));
		inMoneySys.setDateTime(new Date());
		inMoneySysService.save(inMoneySys);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(@RequestBody InMoneySysEntity inMoneySys){
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		//判断 是否支出 还是收入
		int status = inMoneySys.getStatus();
		MyMoneyEntity myMoney = myMoneyService.queryObjectByName(userName);
		if(status==0){//收入
			int totalMoney =Integer.parseInt(inMoneySys.getInMoney()) + myMoney.getMymoney();
			myMoney.setMymoney(totalMoney);
			myMoneyService.update(myMoney);
		}else{
			int totalMoney =myMoney.getMymoney() - Integer.parseInt(inMoneySys.getInMoney());
			myMoney.setMymoney(totalMoney);
			myMoneyService.update(myMoney);
		}
		inMoneySys.setUserName(userName);
		inMoneySys.setUserId(personService.getName(userName));
		inMoneySys.setDateTime(new Date());
		inMoneySysService.update(inMoneySys);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		inMoneySysService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
