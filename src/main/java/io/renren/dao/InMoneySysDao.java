package io.renren.dao;

import java.util.List;
import java.util.Map;

import io.renren.entity.InMoneySysEntity;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 19:39:32
 */
public interface InMoneySysDao extends BaseDao<InMoneySysEntity> {

	List<InMoneySysEntity> queryListOut(Map<String, Object> map);

	List<InMoneySysEntity> queryListFamliy(Map<String, Object> map);
	
}
