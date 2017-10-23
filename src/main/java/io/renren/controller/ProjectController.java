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

import io.renren.entity.ProjectEntity;
import io.renren.service.ProjectService;
import io.renren.utils.PageUtils;
import io.renren.utils.R;


@Controller
@RequestMapping("project")
public class ProjectController {
	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/project.html")
	public String list(){
		return "project/project.html";
	}
	
	@RequestMapping("/project_add.html")
	public String add(){
		return "project/project_add.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("project:list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<ProjectEntity> projectList = projectService.queryList(map);
		int total = projectService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(projectList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Integer id){
		ProjectEntity project = projectService.queryObject(id);
		
		return R.ok().put("project", project);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	public R save(@RequestBody ProjectEntity project){
		projectService.save(project);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(@RequestBody ProjectEntity project){
		projectService.update(project);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	public R delete(@RequestBody Integer[] ids){
		projectService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
