package com.tunayo.springboot.domain.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunayo.springboot.domain.user.model.MUser;
import com.tunayo.springboot.domain.user.service.UserService;
import com.tunayo.springboot.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public void signup(MUser user) {
		user.setDepartmentId(1);
		user.setRole("ROLE_GENERAL");
		mapper.insertOne(user);
	}
	
	@Override
	public List<MUser> getUsers(){
		return mapper.findMany();
	}
}
