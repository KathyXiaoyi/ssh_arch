package ilv.service;

import java.io.Serializable;

import ilv.dao.UserDaoI;
import ilv.model.IlvUser;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService1")
public class UserServiceImpl implements UserServiceI {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger
            .getLogger(UserServiceImpl.class);
    // 需要用到userDaoImpl操纵表TUSER
    private UserDaoI userDao;

    public UserDaoI getUserDao() {
        return userDao;
    }

    // 创建UserServiceImpl时，userDao被自动创建
    @Autowired
    public void setUserDao(UserDaoI userDao) {
        this.userDao = userDao;
    }

    @Override
    public void test() {
        logger.info("打印信息");
    }

    @Override
    public Serializable save(IlvUser user) {
        //调用数据库操作类UserDao操纵数据库
        return userDao.save(user);
    }
}