package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.Role;
import com.how2java.tmall.pojo.RoleExample;

import java.util.List;

public interface RoleMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Role record);

	int insertSelective(Role record);

	List<Role> selectByExample(RoleExample example);

	Role selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Role record);

	int updateByPrimaryKey(Role record);
}