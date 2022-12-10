package com.tunayo.springboot.hello;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
	
	@Autowired
	private HelloService service;
	
	@GetMapping("/hello")
	public String getHello() {
		return "hello";
	}
	
	@PostMapping("/hello")
	public String postRequest(@RequestParam("text1") String str, Model model) {
		model.addAttribute("sample", str);
		
		return "response";		
	}
	
	@PostMapping("hello/db")
	public String postDbRequest(@RequestParam("text2")String id, Model model) {
		
		Employee employee = service.getEmployee(id);
		
		model.addAttribute("employee", employee);
		
		return "/db";
	}
}