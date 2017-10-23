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

import io.renren.entity.MyMoneyEntity;
import io.renren.entity.OutMoneySysEntity;
import io.renren.service.MyMoneyService;
import io.renren.service.OutMoneySysService;
import io.renren.service.PersonService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;
import io.renren.utils.ShiroUtils;

@Controller
@RequestMapping("outmoneysys")
public class OutMoneySysController {
	@Autowired
	private OutMoneySysService outMoneySysService;
	
	@Autowired
	private MyMoneyService myMoneyService;
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/outmoneysys.html")
	public String list(){
		return "outmoneysys/outmoneysys.html";
	}
	
	@RequestMapping("/adminoutmoneysys.html")
	public String adlimList(){
		return "outmoneysys/adminoutmoneysys.html";
	}
	
	@RequestMapping("/outmoneysys_add.html")
	public String add(){
		return "outmoneysys/outmoneysys_add.html";
	}
	
	/**
	 * 我的借贷记录列表
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
		List<OutMoneySysEntity> outMoneySysList = outMoneySysService.queryList(map);
		int total = outMoneySysService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(outMoneySysList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 管理员查看家庭借贷记录列表
	 */
	@ResponseBody
	@RequestMapping("/adminlist")
	public R adminlist(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		map.put("userName", userName);
		//查询列表数据
		List<OutMoneySysEntity> outMoneySysList = outMoneySysService.queryAdminList(map);
		int total = outMoneySysService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(outMoneySysList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		OutMoneySysEntity outMoneySys = outMoneySysService.queryObject(id);
		
		return R.ok().put("outMoneySys", outMoneySys);
	}
	
	/**
	 * 借入 借出保存记录 并更新我的资产 
	 */
	@ResponseBody
	@RequestMapping("/save")
	public R save(@RequestBody OutMoneySysEntity outMoneySys){
		outMoneySys.setDateTime(new Date());
		String trueName = personService.getName(outMoneySys.getProNo());
		outMoneySys.setProName(trueName);
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		outMoneySys.setUserName(personService.getName(userName));
		outMoneySys.setUserId(userName);
		outMoneySysService.save(outMoneySys);
		String status = outMoneySys.getStutas();
		
		//跟新我的资产
		MyMoneyEntity myObj = myMoneyService.queryObjectByName(userName);
		Integer momey = Integer.parseInt(outMoneySys.getOutMoney());
		if("0".equals(status)){
			myObj.setMymoney(myObj.getMymoney()+momey);
		}else{
			myObj.setMymoney(myObj.getMymoney()-momey);
		}
		myMoneyService.update(myObj);
		//跟新另外一个人的资产
		MyMoneyEntity myObj2 = myMoneyService.queryObjectByName(outMoneySys.getProNo());
		if("0".equals(status)){
			myObj2.setMymoney(myObj2.getMymoney()-momey);
		}else{
			myObj2.setMymoney(myObj2.getMymoney()+momey);
		}
		myMoneyService.update(myObj2);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(@RequestBody OutMoneySysEntity outMoneySys){
		outMoneySysService.update(outMoneySys);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		outMoneySysService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
