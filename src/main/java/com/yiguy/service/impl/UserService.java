package com.yiguy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiguy.dao.IBaseDao;
import com.yiguy.model.User;
import com.yiguy.service.IBaseService;

@Service(value = "uService")
public class UserService implements IBaseService<User, String>{
	
	private IBaseDao<User, String> userDao;
	
	public IBaseDao<User, String> getBaseDao() {
		return userDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<User, String> baseDao) {
		this.userDao = baseDao;
	}

	@Override
	public User get(String id) {
		return userDao.get(id);
	}

	@Override
	public String save(User entity) {
		return userDao.save(entity);
	}
}
