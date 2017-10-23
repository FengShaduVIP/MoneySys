package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.OutMoneyDao;
import io.renren.entity.OutMoneyEntity;
import io.renren.service.OutMoneyService;



@Service("outMoneyService")
public class OutMoneyServiceImpl implements OutMoneyService {
	@Autowired
	private OutMoneyDao outMoneyDao;
	
	@Override
	public OutMoneyEntity queryObject(Integer id){
		return outMoneyDao.queryObject(id);
	}
	
	@Override
	public List<OutMoneyEntity> queryList(Map<String, Object> map){
		return outMoneyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return outMoneyDao.queryTotal(map);
	}
	
	@Override
	public void save(OutMoneyEntity outMoney){
		outMoneyDao.save(outMoney);
	}
	
	@Override
	public void update(OutMoneyEntity outMoney){
		outMoneyDao.update(outMoney);
	}
	
	@Override
	public void delete(Integer id){
		outMoneyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		outMoneyDao.deleteBatch(ids);
	}
	
}
