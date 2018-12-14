package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Admin;

public interface UserRoleService {

	public void setRoles(Admin user, Integer[] roleIds);

	public void deleteByUser(Integer userId);

	public void deleteByRole(Integer roleId);

}