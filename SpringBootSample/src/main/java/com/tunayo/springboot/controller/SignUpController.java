package com.tunayo.springboot.controller;

import java.util.Map;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tunayo.springboot.service.UserApplicationService;
import com.tunayo.springboot.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignUpController {
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);
		return "user/signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute SignupForm form) {
		
		log.info(form.toString());
	
		return "redirect:/login";
	}
}
