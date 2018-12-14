package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Role;

public interface RolePermissionService {
	public void setPermissions(Role role, Integer[] permissionIds);

	public void deleteByRole(Integer roleId);

	public void deleteByPermission(Integer permissionId);
}