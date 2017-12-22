package com.yiguy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiguy.dao.IBaseDao;
import com.yiguy.model.User;
import com.yiguy.service.UserServiceI;


@Service(value = "userService")
public class UserServiceImpl implements UserServiceI{
	
	private IBaseDao<User> userDao;
	
	public IBaseDao<User> getBaseDao() {
		return userDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<User> baseDao) {
		this.userDao = baseDao;
	}
	
	@Override
	public String save_user() {
		User user = new User();
		user.setName("hehe");
		user.setAge(10);
		return userDao.save(user).toString();
	}
	
	@Override
	public int getAllUsersCount() {
		String hql = "from User";
		List<User> userList = userDao.find(hql);
		return userList.size();
	}
}
