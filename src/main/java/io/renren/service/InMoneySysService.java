package io.renren.service;

import io.renren.entity.InMoneySysEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-05-09 19:39:32
 */
public interface InMoneySysService {
	
	InMoneySysEntity queryObject(Integer id);
	
	List<InMoneySysEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(InMoneySysEntity inMoneySys);
	
	void update(InMoneySysEntity inMoneySys);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	List<InMoneySysEntity> queryListOut(Map<String, Object> map);

	List<InMoneySysEntity> queryListFamliy(Map<String, Object> map);
}
