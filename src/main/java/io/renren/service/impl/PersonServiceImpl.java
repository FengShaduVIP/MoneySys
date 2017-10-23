package io.renren.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import io.renren.dao.PersonDao;
import io.renren.entity.PersonEntity;
import io.renren.service.PersonService;



@Service("personService")
public class PersonServiceImpl implements PersonService {
	@Autowired
	private PersonDao personDao;
	
	@Override
	public PersonEntity queryObject(Integer id){
		return personDao.queryObject(id);
	}
	
	@Override
	public List<PersonEntity> queryList(Map<String, Object> map){
		return personDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return personDao.queryTotal(map);
	}
	
	@Override
	public void save(PersonEntity person){
		personDao.save(person);
	}
	
	@Override
	public void update(PersonEntity person){
		personDao.update(person);
	}
	
	@Override
	public void delete(Integer id){
		personDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		personDao.deleteBatch(ids);
	}
	
	/**
	 * 更具用户名查询 家庭代码
	 * @param userName
	 */
	@Override
	public PersonEntity getFamliyCode(String userName){
		return personDao.getFamliyCode(userName);
	}
	
	
	/**
	 * 更具用户名返回 姓名
	 */
	@Override
	public String getName(String userName){
		return personDao.getName(userName);
	}

	@Override
	public List<PersonEntity> queryAllFamliyPerson(String famliyCode) {
		return personDao.queryAllFamliyPerson(famliyCode);
	}
}
