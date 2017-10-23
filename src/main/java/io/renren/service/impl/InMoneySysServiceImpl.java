package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.InMoneySysDao;
import io.renren.entity.InMoneySysEntity;
import io.renren.service.InMoneySysService;



@Service("inMoneySysService")
public class InMoneySysServiceImpl implements InMoneySysService {
	@Autowired
	private InMoneySysDao inMoneySysDao;
	
	@Override
	public InMoneySysEntity queryObject(Integer id){
		return inMoneySysDao.queryObject(id);
	}
	
	@Override
	public List<InMoneySysEntity> queryList(Map<String, Object> map){
		return inMoneySysDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return inMoneySysDao.queryTotal(map);
	}
	
	@Override
	public void save(InMoneySysEntity inMoneySys){
		inMoneySysDao.save(inMoneySys);
	}
	
	@Override
	public void update(InMoneySysEntity inMoneySys){
		inMoneySysDao.update(inMoneySys);
	}
	
	@Override
	public void delete(Integer id){
		inMoneySysDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		inMoneySysDao.deleteBatch(ids);
	}

	@Override
	public List<InMoneySysEntity> queryListOut(Map<String, Object> map) {
		return inMoneySysDao.queryListOut(map);
	}

	@Override
	public List<InMoneySysEntity> queryListFamliy(Map<String, Object> map) {
		return inMoneySysDao.queryListFamliy(map);
	}
	
}
