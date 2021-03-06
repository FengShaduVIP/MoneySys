package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.ProjectDao;
import io.renren.entity.ProjectEntity;
import io.renren.service.ProjectService;



@Service("projectService")
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectDao projectDao;
	
	@Override
	public ProjectEntity queryObject(Integer id){
		return projectDao.queryObject(id);
	}
	
	@Override
	public List<ProjectEntity> queryList(Map<String, Object> map){
		return projectDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return projectDao.queryTotal(map);
	}
	
	@Override
	public void save(ProjectEntity project){
		projectDao.save(project);
	}
	
	@Override
	public void update(ProjectEntity project){
		projectDao.update(project);
	}
	
	@Override
	public void delete(Integer id){
		projectDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		projectDao.deleteBatch(ids);
	}

	@Override
	public List<ProjectEntity> queryProjectList(){
		return projectDao.queryProjectList();
	}

	@Override
	public ProjectEntity queryObjectByNo(String params) {
		return projectDao.queryObjectByNo(params);
	}
	
}
