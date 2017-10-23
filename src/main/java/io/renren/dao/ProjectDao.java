package io.renren.dao;

import java.util.List;

import io.renren.entity.ProjectEntity;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-05 22:13:02
 */
public interface ProjectDao extends BaseDao<ProjectEntity> {

	List<ProjectEntity> queryProjectList();

	ProjectEntity queryObjectByNo(String params);
	
}
