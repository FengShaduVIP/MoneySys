package io.renren.service;

import io.renren.entity.MyMoneyEntity;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 21:23:40
 */
public interface MyMoneyService {
	
	MyMoneyEntity queryObject(Integer id);
	
	List<MyMoneyEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(MyMoneyEntity myMoney);
	
	void update(MyMoneyEntity myMoney);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	List<MyMoneyEntity> queryMyList(Map<String, Object> map);

	MyMoneyEntity queryObjectByName(String userName);
	
	void updateMymoney (String userName,int money);

}
