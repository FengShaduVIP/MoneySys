package io.renren.dao;

import java.util.List;
import java.util.Map;

import io.renren.entity.OutMoneySysEntity;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-19 16:50:09
 */
public interface OutMoneySysDao extends BaseDao<OutMoneySysEntity> {

	List<OutMoneySysEntity> queryAdminList(Map<String, Object> map);
	
}
