package com.tunayo.springboot.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;


@Service
public class UserApplicationService {
	
	@Autowired
	private MessageSource messageSource;
	
//	private MessageSource messageSource = new UserApplicationService.genderMap();

	public Map<String, Integer> getGenderMap(Locale locale){
		Map<String, Integer> genderMap = new LinkedHashMap<>();
		String male = messageSource.getMessage("male", null, locale);
		String female = messageSource.getMessage("female", null, locale);
		genderMap.put(male, 1);
		genderMap.put(female, 2);
		return genderMap;
	}
}
