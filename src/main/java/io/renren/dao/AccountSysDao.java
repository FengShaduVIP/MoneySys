package io.renren.dao;

import java.util.List;
import java.util.Map;

import io.renren.entity.AccountSysEntity;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 21:49:38
 */
public interface AccountSysDao extends BaseDao<AccountSysEntity> {

	List<AccountSysEntity> queryAdminList(Map<String, Object> map);
	
}
