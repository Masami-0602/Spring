package com.tunayo.springboot.controller;

import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.tunayo.springboot.domain.user.service.UserService;

import org.springframework.ui.Model;

import com.tunayo.springboot.domain.user.model.MUser;

@Controller
@RequestMapping("/user")
public class UserListController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/list")
	public String getUserList(Model model) {
		
		List<MUser> userList = userService.getUsers();
		
		model.addAttribute("userList", userList);
		
		return "user/list";
	}	
}