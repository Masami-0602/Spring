package com.tunayo.springboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tunayo.springboot.service.UserApplicationService;

@Controller
@RequestMapping("/user")
public class SignUpController {
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	@GetMapping("/signup")
	public String getSignup(Model model) {
		Map<String, Integer> genderMap = userApplicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);
		return "user/signup";
	}
	
	@PostMapping("/signup")
	public String postSingup() {
		return "redirect:/login";
	}
}
