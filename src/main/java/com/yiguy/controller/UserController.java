package com.yiguy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiguy.model.User;
import com.yiguy.service.IBaseService;

@Controller
@RequestMapping("/user")
public class UserController {

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
