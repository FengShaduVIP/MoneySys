package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.InMoneyDao;
import io.renren.entity.InMoneyEntity;
import io.renren.service.InMoneyService;



@Service("inMoneyService")
public class InMoneyServiceImpl implements InMoneyService {
	@Autowired
	private InMoneyDao inMoneyDao;
	
	@Override
	public InMoneyEntity queryObject(Integer id){
		return inMoneyDao.queryObject(id);
	}
	
	@Override
	public List<InMoneyEntity> queryList(Map<String, Object> map){
		return inMoneyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return inMoneyDao.queryTotal(map);
	}
	
	@Override
	public void save(InMoneyEntity inMoney){
		inMoneyDao.save(inMoney);
	}
	
	@Override
	public void update(InMoneyEntity inMoney){
		inMoneyDao.update(inMoney);
	}
	
	@Override
	public void delete(Integer id){
		inMoneyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		inMoneyDao.deleteBatch(ids);
	}
	
}
