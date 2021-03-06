package com.how2java.tmall.mapper;

import com.how2java.tmall.pojo.UserRole;
import com.how2java.tmall.pojo.UserRoleExample;
import java.util.List;

public interface UserRoleMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(UserRole record);

	int insertSelective(UserRole record);

	List<UserRole> selectByExample(UserRoleExample example);

	UserRole selectByPrimaryKey(Integer id);

	List<UserRole> selectByUid(Integer uid);

	int updateByPrimaryKeySelective(UserRole record);

	int updateByPrimaryKey(UserRole record);
}