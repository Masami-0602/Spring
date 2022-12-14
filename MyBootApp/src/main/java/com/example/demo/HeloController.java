package com.example.demo;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.*;

@Controller
public class HeloController {
	
	@RequestMapping("/")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		ArrayList<DataObject> data = new ArrayList<DataObject>();
		data.add(new DataObject(0,"taro","taro@yamada"));
		data.add(new DataObject(1,"hanako","hanako@flower"));
		data.add(new DataObject(2,"sachiko","sachiko@happy"));
		mav.addObject("data", data);
		return mav;
	}
	
	@RequestMapping("/{num}")
	public ModelAndView index(@PathVariable int num,
			ModelAndView mav) {
		mav.setViewName("index");
		mav.addObject("num",num);
		if (num >= 0){
			mav.addObject("check","num >= data.size() ? 0 : num");
		} else {
			mav.addObject("check","num <= data.size() * -1 ? 0 : num * -1");
		}
		ArrayList<DataObject> data = new ArrayList<DataObject>();
		data.add(new DataObject(0,"taro","taro@yamada"));
		data.add(new DataObject(1,"hanako","hanako@flower"));
		data.add(new DataObject(2,"sachiko","sachiko@happy"));
		mav.addObject("data",data);
		return mav;
	}
	
	@RequestMapping("/other")
	public String other() {
		 return "redirect:/";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "forward:/";
	}

}