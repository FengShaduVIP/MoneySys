package io.renren.service;

import io.renren.entity.ChooseSysEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 22:17:04
 */
public interface ChooseSysService {
	
	ChooseSysEntity queryObject(Integer id);
	
	List<ChooseSysEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ChooseSysEntity chooseSys);
	
	void update(ChooseSysEntity chooseSys);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
	
	List<ChooseSysEntity> getProjectList();

	List<ChooseSysEntity> queryListByAdmin(Map<String, Object> map);
}
