package com.tunayo.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tunayo.springboot.domain.user.model.MUser;

@Mapper
public interface UserMapper {

	public int insertOne(MUser user);
	
	public List<MUser> findMany();
}
