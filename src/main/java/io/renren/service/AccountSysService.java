package io.renren.service;

import io.renren.entity.AccountSysEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 21:49:38
 */
public interface AccountSysService {
	
	AccountSysEntity queryObject(Integer id);
	
	List<AccountSysEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(AccountSysEntity accountSys);
	
	void update(AccountSysEntity accountSys);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	List<AccountSysEntity> queryAdminList(Map<String, Object> map);
}
