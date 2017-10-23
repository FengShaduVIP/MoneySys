package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.OutMoneySysDao;
import io.renren.entity.OutMoneySysEntity;
import io.renren.service.OutMoneySysService;



@Service("outMoneySysService")
public class OutMoneySysServiceImpl implements OutMoneySysService {
	@Autowired
	private OutMoneySysDao outMoneySysDao;
	
	@Override
	public OutMoneySysEntity queryObject(Integer id){
		return outMoneySysDao.queryObject(id);
	}
	
	@Override
	public List<OutMoneySysEntity> queryList(Map<String, Object> map){
		return outMoneySysDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return outMoneySysDao.queryTotal(map);
	}
	
	@Override
	public void save(OutMoneySysEntity outMoneySys){
		outMoneySysDao.save(outMoneySys);
	}
	
	@Override
	public void update(OutMoneySysEntity outMoneySys){
		outMoneySysDao.update(outMoneySys);
	}
	
	@Override
	public void delete(Integer id){
		outMoneySysDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		outMoneySysDao.deleteBatch(ids);
	}

	@Override
	public List<OutMoneySysEntity> queryAdminList(Map<String, Object> map) {
		return outMoneySysDao.queryAdminList(map);
	}
	
}
