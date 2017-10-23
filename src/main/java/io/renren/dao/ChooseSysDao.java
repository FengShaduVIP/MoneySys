package io.renren.dao;

import java.util.List;
import java.util.Map;

import io.renren.entity.ChooseSysEntity;

/**
 * 
 * 
 * @author FengShadu
 * @email twpvip@gmail.com
 * @date 2017-04-25 22:17:04
 */
public interface ChooseSysDao extends BaseDao<ChooseSysEntity> {
	public List<ChooseSysEntity> getProjectList();

	public List<ChooseSysEntity> queryListByAdmin(Map<String, Object> map);
}
