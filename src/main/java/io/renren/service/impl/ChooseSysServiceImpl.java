package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.ChooseSysDao;
import io.renren.entity.ChooseSysEntity;
import io.renren.service.ChooseSysService;



@Service("chooseSysService")
public class ChooseSysServiceImpl implements ChooseSysService {
	@Autowired
	private ChooseSysDao chooseSysDao;
	
	@Override
	public ChooseSysEntity queryObject(Integer id){
		return chooseSysDao.queryObject(id);
	}
	
	@Override
	public List<ChooseSysEntity> queryList(Map<String, Object> map){
		return chooseSysDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return chooseSysDao.queryTotal(map);
	}
	
	@Override
	public void save(ChooseSysEntity chooseSys){
		chooseSysDao.save(chooseSys);
	}
	
	@Override
	public void update(ChooseSysEntity chooseSys){
		chooseSysDao.update(chooseSys);
	}
	
	@Override
	public void delete(Integer id){
		chooseSysDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		chooseSysDao.deleteBatch(ids);
	}
	
	@Override
	public List<ChooseSysEntity> getProjectList(){
		return chooseSysDao.getProjectList();
	}

	@Override
	public List<ChooseSysEntity> queryListByAdmin(Map<String, Object> map) {
		return chooseSysDao.queryListByAdmin(map);
	}
	
}
