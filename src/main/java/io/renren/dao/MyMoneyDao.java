package io.renren.dao;

import java.util.List;
import java.util.Map;

import io.renren.entity.MyMoneyEntity;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 21:23:40
 */
public interface MyMoneyDao extends BaseDao<MyMoneyEntity> {

	List<MyMoneyEntity> queryMyList(Map<String, Object> map);

	MyMoneyEntity queryObjectByName(String userName);
	
}
