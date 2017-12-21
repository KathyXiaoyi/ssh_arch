package ilv.dao.impl;

import ilv.dao.UserDaoI;
import ilv.model.IlvUser;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//注解方式，让spring管理
//dao类推荐@Repository，service类推荐@Service
@Repository("UserDao1")
public class UserDaoImpl implements UserDaoI{

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    //当创建UserDaoImpl时，sessionFactory自动被创建注入
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Serializable save(IlvUser user) {
        // TODO Auto-generated method stub
    	System.out.println(sessionFactory);
        return this.sessionFactory.getCurrentSession().save(user);
    }
}