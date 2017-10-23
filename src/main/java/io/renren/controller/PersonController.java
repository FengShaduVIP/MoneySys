package io.renren.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import io.renren.entity.MyMoneyEntity;
import io.renren.entity.PersonEntity;
import io.renren.entity.SysUserEntity;
import io.renren.service.MyMoneyService;
import io.renren.service.PersonService;
import io.renren.service.SysUserService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;
import io.renren.utils.ShiroUtils;


/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 17:49:03
 */
@Controller
@RequestMapping("person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@Autowired
	private MyMoneyService myMoneyService;
	
	@Autowired
	private SysUserService sysUserService;
	
	
	@RequestMapping("/person.html")
	public String list(){
		return "person/person.html";
	}
	
	@RequestMapping("/person_add.html")
	public String add(){
		return "person/person_add.html";
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
		map.put("FamilyCode", userName);
		//查询列表数据
		List<PersonEntity> personList = personService.queryList(map);
		int total = personService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(personList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		PersonEntity person = personService.queryObject(id);
		
		return R.ok().put("person", person);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public R save(@RequestBody PersonEntity person,HttpServletRequest request){
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		person.setFamilyCode(userName);
		personService.save(person);
		//保存人员资产初始化
		MyMoneyEntity myMoney = new MyMoneyEntity();
		myMoney.setMymoney(10000);
		myMoney.setUserId(person.getPersonName());
		myMoney.setUserName(person.getUserName());
		myMoneyService.save(myMoney);
		SysUserEntity user = new SysUserEntity();
		user.setCreateTime(new Date());
		user.setStatus(1);
		user.setUsername(person.getUserName());
		user.setPassword("123456");
		List<Long> roleIdList= new ArrayList<Long>();
		Long roleId = (long) 5;
		roleIdList.add(roleId);
		user.setRoleIdList(roleIdList);
		sysUserService.save(user);
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(@RequestBody PersonEntity person){
		personService.update(person);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		for(int i=0;i<ids.length;i++){
			PersonEntity person = personService.queryObject(ids[i]);
			String userName= person.getUserName();
			sysUserService.deleteUser(userName);
		}
		personService.deleteBatch(ids);
		return R.ok();
	}
	
	/**
	 * 普通用户
	 * 获取当前家族的 人员列表
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getPersson")
	public R getPersson(){
		String userName = ShiroUtils.getSessionAttribute("username").toString();
		PersonEntity obj = personService.getFamliyCode(userName);
		String famliyCode = obj.getFamilyCode();
		List<PersonEntity> personList = personService.queryAllFamliyPerson(famliyCode);
		//去除家族人员中我自己
		for (int i = 0; i < personList.size(); i++) {
			PersonEntity personObj = personList.get(i);
			if(userName.equals(personObj.getUserName())){
				personList.remove(i);
			}
		}
		return R.ok().put("data", personList);
	}
}
