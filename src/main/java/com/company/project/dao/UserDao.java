package com.company.project.dao;


import com.company.project.core.Mapper;
import com.company.project.model.User;

import java.util.List;
import java.util.Map;

public interface UserDao extends Mapper<User> {

	List<User> getByMap(Map<String, Object> map);
	User getById(Integer id);
	Integer create(User user);
	int update(User user);
	int deleteById(Integer id);
	User getByUserName(String userName);
}