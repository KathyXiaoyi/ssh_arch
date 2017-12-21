package com.yiguy.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.yiguy.dao.IBaseDao;
import com.yiguy.model.User;

@Repository("userDao")
public class UserDao implements IBaseDao<User, String>{
	private Class<User> entityClass;

	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public UserDao() {
		this.entityClass = null;
		Class<?> c = getClass();
		Type type = c.getGenericSuperclass();
		if (type instanceof ParameterizedType) {
			Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
			this.entityClass = (Class<User>) parameterizedType[0];
		}
	}
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		System.out.println(sessionFactory);
		return sessionFactory.getCurrentSession();
	}

	@Override
	public User get(String id) {
		Assert.notNull(id, "id is required");
		return (User) getSession().get(entityClass, id);
	}

	@Override
	public String save(User entity) {
		Assert.notNull(entity, "entity is required");
		String id = (String) getSession().save(entity);
		return id;
	}

}
