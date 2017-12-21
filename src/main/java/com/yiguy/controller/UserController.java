package com.yiguy.controller;

import java.sql.Timestamp;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiguy.model.User;
import com.yiguy.service.IBaseService;
import com.yiguy.service.impl.UserService;

import ilv.dao.impl.UserDaoImpl;
import ilv.model.IlvUser;
import ilv.service.UserServiceI;
import ilv.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
 
	/*private UserServiceI userService;
	
	public UserServiceI getUserService() {
	    return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
	    this.userService = userService;
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	@ResponseBody
	public void addUser() {
        IlvUser user = new IlvUser();
        // 设置UUID主键
        user.setId(UUID.randomUUID().toString());
        user.setRealname("yanglang");
        user.setUsername("superadmin");
        user.setPassword("hello");
        user.setIslock("1");
        user.setStatus("1");
        user.setCreatetime(new Timestamp(System.currentTimeMillis()));
        userService.save(user);
    }*/
	
	private IBaseService<User, String> uService;
	
	public IBaseService<User, String> getuService() {
		return uService;
	}
	
	@Autowired
	public void setuService(IBaseService<User, String> uService) {
		this.uService = uService;
	}

	@RequestMapping(value="/create_user", method=RequestMethod.GET)
	@ResponseBody
	public String hello(HttpServletRequest request) {
		User user = new User();
		user.setId("1000");
		user.setName("xiaoyi");
		user.setAge(25);
		String userId = uService.save(user);
		return userId;
	}
}
