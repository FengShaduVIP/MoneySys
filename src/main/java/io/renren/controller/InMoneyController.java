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

import io.renren.entity.InMoneyEntity;
import io.renren.service.InMoneyService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;


/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 22:04:32
 */
@Controller
@RequestMapping("inmoney")
public class InMoneyController {
	@Autowired
	private InMoneyService inMoneyService;
	
	@RequestMapping("/inmoney.html")
	public String list(){
		return "inmoney/inmoney.html";
	}
	
	@RequestMapping("/inmoney_add.html")
	public String add(){
		return "inmoney/inmoney_add.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("inmoney:list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<InMoneyEntity> inMoneyList = inMoneyService.queryList(map);
		int total = inMoneyService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(inMoneyList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	@RequiresPermissions("inmoney:info")
	public R info(@PathVariable("id") Integer id){
		InMoneyEntity inMoney = inMoneyService.queryObject(id);
		
		return R.ok().put("inMoney", inMoney);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("inmoney:save")
	public R save(@RequestBody InMoneyEntity inMoney){
		inMoneyService.save(inMoney);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("inmoney:update")
	public R update(@RequestBody InMoneyEntity inMoney){
		inMoneyService.update(inMoney);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("inmoney:delete")
	public R delete(@RequestBody Integer[] ids){
		inMoneyService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
