package io.renren.service;

import io.renren.entity.OutMoneyEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 22:04:33
 */
public interface OutMoneyService {
	
	OutMoneyEntity queryObject(Integer id);
	
	List<OutMoneyEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(OutMoneyEntity outMoney);
	
	void update(OutMoneyEntity outMoney);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
