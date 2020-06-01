package com.company.project.dao;


import com.company.project.core.Mapper;
import com.company.project.model.Permission;

import java.util.List;
import java.util.Map;

public interface PermissionDao extends Mapper<Permission> {

    List<Permission> getByMap(Map<String, Object> map);

    Permission getById(Integer id);

    Integer create(Permission permission);

    int update(Permission permission);

    int deleteById(Integer id);

    List<Permission> getList();

    List<Permission> getByUserId(Integer userId);

}