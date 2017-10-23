package io.renren.controller;

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
import io.renren.service.MyMoneyService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;
import io.renren.utils.ShiroUtils;


/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 21:23:40
 */
@Controller
@RequestMapping("mymoney")
public class MyMoneyController {
	@Autowired
	private MyMoneyService myMoneyService;
	
	@RequestMapping("/mymoney.html")
	public String list(){
		return "mymoney/mymoney.html";
	}
	
	@RequestMapping("/famliy.html")
	public String listAdmin(){
		return "mymoney/famliy.html";
	}
	
	@RequestMapping("/mymoney_add.html")
	public String add(){
		return "mymoney/mymoney_add.html";
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
		map.put("family_code", userName);
		//查询列表数据
		List<MyMoneyEntity> myMoneyList = myMoneyService.queryList(map);
		int total = myMoneyService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(myMoneyList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/mylist")
	public R mylist(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		map.put("userName", userName);
		//查询列表数据
		List<MyMoneyEntity> myMoneyList = myMoneyService.queryMyList(map);
		int total = myMoneyService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(myMoneyList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		MyMoneyEntity myMoney = myMoneyService.queryObject(id);
		
		return R.ok().put("myMoney", myMoney);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public R save(@RequestBody MyMoneyEntity myMoney){
		myMoneyService.save(myMoney);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(@RequestBody MyMoneyEntity myMoney){
		myMoneyService.update(myMoney);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		myMoneyService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
