package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Permission;
import com.how2java.tmall.pojo.PermissionExample;

import java.util.List;

public interface PermissionMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Permission record);

	int insertSelective(Permission record);

	List<Permission> selectByExample(PermissionExample example);

	Permission selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Permission record);

	int updateByPrimaryKey(Permission record);
}