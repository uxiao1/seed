package com.company.project.dao;


import com.company.project.core.Mapper;
import com.company.project.model.Role;

import java.util.List;
import java.util.Map;

public interface RoleDao extends Mapper<Role> {

	List<Role> getByMap(Map<String, Object> map);
	Role getById(Integer id);
	Integer create(Role role);
	int update(Role role);
	int deleteById(Integer id);
}