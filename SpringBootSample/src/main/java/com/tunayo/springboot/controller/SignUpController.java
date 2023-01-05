package com.tunayo.springboot.controller;

import java.util.Map;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.*;

import com.tunayo.springboot.service.UserApplicationService;
import com.tunayo.springboot.domain.user.service.UserService;
import com.tunayo.springboot.domain.user.model.MUser;

import com.tunayo.springboot.form.SignupForm;
import com.tunayo.springboot.form.GroupOrder;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignUpController {
	
	@Autowired
	private UserApplicationService userApplicationService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping("/signup")
	public String getSignup(Model model, Locale locale, @ModelAttribute SignupForm form) {
		Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
		model.addAttribute("genderMap", genderMap);
		return "user/signup";
	}
	
	@PostMapping("/signup")
	public String postSignup(Model model, Locale locale, @ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) {
			return getSignup(model, locale, form);
		}
		
		log.info(form.toString());
		
		MUser user = modelMapper.map(form, MUser.class);

		userService.signup(user);
		
		return "redirect:/login";
	}
}
