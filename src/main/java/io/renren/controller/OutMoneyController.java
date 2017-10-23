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

import io.renren.entity.OutMoneyEntity;
import io.renren.service.OutMoneyService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;


/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 22:04:33
 */
@Controller
@RequestMapping("outmoney")
public class OutMoneyController {
	@Autowired
	private OutMoneyService outMoneyService;
	
	@RequestMapping("/outmoney.html")
	public String list(){
		return "outmoney/outmoney.html";
	}
	
	@RequestMapping("/outmoney_add.html")
	public String add(){
		return "outmoney/outmoney_add.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("outmoney:list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<OutMoneyEntity> outMoneyList = outMoneyService.queryList(map);
		int total = outMoneyService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(outMoneyList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("outmoney:info")
	public R info(@PathVariable("id") Integer id){
		OutMoneyEntity outMoney = outMoneyService.queryObject(id);
		
		return R.ok().put("outMoney", outMoney);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("outmoney:save")
	public R save(@RequestBody OutMoneyEntity outMoney){
		outMoneyService.save(outMoney);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("outmoney:update")
	public R update(@RequestBody OutMoneyEntity outMoney){
		outMoneyService.update(outMoney);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("outmoney:delete")
	public R delete(@RequestBody Integer[] ids){
		outMoneyService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
