package com.yiguy.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yiguy.service.impl.UserService;

public class UserController {
	
	@RequestMapping("/hello")
	public String hello(Model model) {
		/*UserService userService = new UserService();
		String userId = userService.save_user();*/
		String userId="1000";
		// model.addAttribute("massage", userId);
		return userId;
	}
}
