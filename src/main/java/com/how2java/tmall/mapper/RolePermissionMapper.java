package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.RolePermission;
import com.how2java.tmall.pojo.RolePermissionExample;
import java.util.List;

public interface RolePermissionMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(RolePermission record);

	int insertSelective(RolePermission record);

	List<RolePermission> selectByExample(RolePermissionExample example);

	RolePermission selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(RolePermission record);

	int updateByPrimaryKey(RolePermission record);
}