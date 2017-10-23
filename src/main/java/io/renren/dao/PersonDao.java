package io.renren.dao;

import java.util.List;

import io.renren.entity.PersonEntity;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 17:49:03
 */
public interface PersonDao extends BaseDao<PersonEntity> {
	PersonEntity getFamliyCode(String userName);
	
	String getName(String userName);

	List<PersonEntity> queryAllFamliyPerson(String famliyCode);
}
