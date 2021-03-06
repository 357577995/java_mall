package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.RolePermissionMapper;
import com.how2java.tmall.pojo.Permission;
import com.how2java.tmall.pojo.Role;
import com.how2java.tmall.pojo.RolePermission;
import com.how2java.tmall.pojo.RolePermissionExample;
import com.how2java.tmall.service.RolePermissionService;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {

	@Autowired
	RolePermissionMapper rolePermissionMapper;

	@Override
	public void setPermissions(Role role, Integer[] permissionIds) {
		// 删除当前角色所有的权限
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRidEqualTo(role.getId());
		List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
		for (RolePermission rolePermission : rps)
			rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());

		// 设置新的权限关系
		if (null != permissionIds)
			for (Integer pid : permissionIds) {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setPid(pid);
				rolePermission.setRid(role.getId());
				rolePermissionMapper.insert(rolePermission);
			}
	}

	@Override
	public void deleteByRole(Integer roleId) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andRidEqualTo(roleId);
		List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
		for (RolePermission rolePermission : rps)
			rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
	}

	@Override
	public void deleteByPermission(Integer permissionId) {
		RolePermissionExample example = new RolePermissionExample();
		example.createCriteria().andPidEqualTo(permissionId);
		List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
		for (RolePermission rolePermission : rps)
			rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
	}

}