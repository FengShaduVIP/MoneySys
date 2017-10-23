package io.renren.service;

import io.renren.entity.InMoneyEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 22:04:32
 */
public interface InMoneyService {
	
	InMoneyEntity queryObject(Integer id);
	
	List<InMoneyEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InMoneyEntity inMoney);
	
	void update(InMoneyEntity inMoney);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
