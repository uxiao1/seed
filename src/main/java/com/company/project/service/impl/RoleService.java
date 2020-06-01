package com.company.project.service.impl;


import com.company.project.dao.RoleDao;
import com.company.project.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleService {
    @Autowired(required = false)
	private RoleDao roleDao;
	
	public List<Role> getByMap(Map<String,Object> map) {
	    return roleDao.getByMap(map);
	}
	
	public Role getById(Integer id) {
		return roleDao.getById(id);
	}
	
	public Role create(Role role) {
		roleDao.create(role);
		return role;
	}
	
	public Role update(Role role) {
		roleDao.update(role);
		return role;
	}
	
	public int delete(Integer id) {
		return roleDao.deleteById(id);
	}
    
}