package io.renren.service;

import io.renren.entity.ProjectEntity;

import java.util.List;
import java.util.Map;

public interface ProjectService {
	
	ProjectEntity queryObject(Integer id);
	
	List<ProjectEntity> queryList(Map<String, Object> map);
	
	List<ProjectEntity> queryProjectList();
	
	int queryTotal(Map<String, Object> map);
	
	void save(ProjectEntity project);
	
	void update(ProjectEntity project);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	ProjectEntity queryObjectByNo(String params);
	
	
}
