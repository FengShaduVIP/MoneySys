package io.renren.service;

import io.renren.entity.PersonEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 17:49:03
 */
public interface PersonService {
	
	PersonEntity queryObject(Integer id);
	
	List<PersonEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PersonEntity person);
	
	void update(PersonEntity person);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	PersonEntity getFamliyCode(String userName);

	String getName(String userName);

	List<PersonEntity> queryAllFamliyPerson(String famliyCode);
}
