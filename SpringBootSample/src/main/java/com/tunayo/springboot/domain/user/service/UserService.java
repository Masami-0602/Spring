package com.tunayo.springboot.domain.user.service;

import java.util.List;

import com.tunayo.springboot.domain.user.model.MUser;

public interface UserService {

	public void signup(MUser user);
	
	public List<MUser> getUsers();	
}