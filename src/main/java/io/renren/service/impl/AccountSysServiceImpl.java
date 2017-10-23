package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.AccountSysDao;
import io.renren.entity.AccountSysEntity;
import io.renren.service.AccountSysService;



@Service("accountSysService")
public class AccountSysServiceImpl implements AccountSysService {
	@Autowired
	private AccountSysDao accountSysDao;
	
	@Override
	public AccountSysEntity queryObject(Integer id){
		return accountSysDao.queryObject(id);
	}
	
	@Override
	public List<AccountSysEntity> queryList(Map<String, Object> map){
		return accountSysDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return accountSysDao.queryTotal(map);
	}
	
	@Override
	public void save(AccountSysEntity accountSys){
		accountSysDao.save(accountSys);
	}
	
	@Override
	public void update(AccountSysEntity accountSys){
		accountSysDao.update(accountSys);
	}
	
	@Override
	public void delete(Integer id){
		accountSysDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		accountSysDao.deleteBatch(ids);
	}

	@Override
	public List<AccountSysEntity> queryAdminList(Map<String, Object> map) {
		return accountSysDao.queryAdminList(map);
	}
	
}
