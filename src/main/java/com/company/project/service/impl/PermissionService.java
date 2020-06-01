package com.company.project.service.impl;


import com.company.project.dao.PermissionDao;
import com.company.project.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PermissionService {
    @Autowired(required = false)
	private PermissionDao permissionDao;
	
	public List<Permission> getByMap(Map<String,Object> map) {
	    return permissionDao.getByMap(map);
	}
	
	public Permission getById(Integer id) {
		return permissionDao.getById(id);
	}
	
	public Permission create(Permission permission) {
		permissionDao.create(permission);
		return permission;
	}
	
	public Permission update(Permission permission) {
		permissionDao.update(permission);
		return permission;
	}
	
	public int delete(Integer id) {
		return permissionDao.deleteById(id);
	}

	public List<Permission> getByUserId(Integer userId) {
		return permissionDao.getByUserId(userId);
	}
}