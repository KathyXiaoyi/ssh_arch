package com.yiguy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiguy.dao.IBaseDao;
import com.yiguy.model.User;


@Service(value = "userService")
public class UserService {
	
	private IBaseDao<User> userDao;
	
	public IBaseDao<User> getBaseDao() {
		return userDao;
	}
	
	@Autowired
	public void setBaseDao(IBaseDao<User> baseDao) {
		this.userDao = baseDao;
	}
	
	public int save_user() {
		User user = new User();
		user.setName("hehe");
		user.setAge(10);
		return (int) userDao.save(user);
	}
	
	public int getAllUsersCount() {
		String hql = "from User";
		List<User> userList = userDao.find(hql);
		return userList.size();
	}
}
