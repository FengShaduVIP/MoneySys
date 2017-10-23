package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.MyMoneyDao;
import io.renren.entity.MyMoneyEntity;
import io.renren.service.MyMoneyService;



@Service("myMoneyService")
public class MyMoneyServiceImpl implements MyMoneyService {
	@Autowired
	private MyMoneyDao myMoneyDao;
	
	@Override
	public MyMoneyEntity queryObject(Integer id){
		return myMoneyDao.queryObject(id);
	}
	
	@Override
	public List<MyMoneyEntity> queryList(Map<String, Object> map){
		return myMoneyDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return myMoneyDao.queryTotal(map);
	}
	
	@Override
	public void save(MyMoneyEntity myMoney){
		myMoneyDao.save(myMoney);
	}
	
	@Override
	public void update(MyMoneyEntity myMoney){
		myMoneyDao.update(myMoney);
	}
	
	@Override
	public void delete(Integer id){
		myMoneyDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		myMoneyDao.deleteBatch(ids);
	}

	@Override
	public List<MyMoneyEntity> queryMyList(Map<String, Object> map) {
		return myMoneyDao.queryMyList(map);
	}

	@Override
	public MyMoneyEntity queryObjectByName(String userName) {
		return myMoneyDao.queryObjectByName(userName);
	}

	@Override
	public void updateMymoney(String userName, int money) {
		MyMoneyEntity entity = myMoneyDao.queryObjectByName(userName);
		int mymoney = entity.getMymoney();
		entity.setMymoney(mymoney+money);
		myMoneyDao.update(entity);
	}
	
}
