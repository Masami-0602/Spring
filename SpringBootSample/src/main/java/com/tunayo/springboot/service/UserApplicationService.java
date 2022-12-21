package com.tunayo.springboot.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {

	public Map<String, Integer> getGenderMap(){
		Map<String, Integer> genderMap = new LinkedHashMap<>();
		genderMap.put("�j��", 1);
		genderMap.put("����", 2);
		return genderMap;
	}
}
