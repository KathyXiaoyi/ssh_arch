package com.yiguy.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yiguy.service.UserServiceI;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserServiceI uService;
	
	public UserServiceI getuService() {
		return uService;
	}
	
	@Autowired
	public void setuService(UserServiceI uService) {
		this.uService = uService;
	}

	@RequestMapping(value="/create_user", method=RequestMethod.GET)
	@ResponseBody
	public String create_user(HttpServletRequest request) {
		String userId = uService.save_user();
		return userId;
	}
	
	@RequestMapping(value="/count", method=RequestMethod.GET)
	@ResponseBody
	public String get_count(HttpServletRequest request) {
		int count = uService.getAllUsersCount();
		return count+"";
	}
}
