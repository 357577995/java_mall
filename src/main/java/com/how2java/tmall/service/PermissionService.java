package com.how2java.tmall.service;

import java.util.List;
import java.util.Set;

import com.how2java.tmall.pojo.Permission;
import com.how2java.tmall.pojo.Role;

public interface PermissionService {
	public Set<String> listPermissions(String userName);

	public List<Permission> list();

	public void add(Permission permission);

	public void delete(Integer id);

	public Permission get(Integer id);

	public void update(Permission permission);

	public List<Permission> list(Role role);

	public boolean needInterceptor(String requestURI);

	public Set<String> listPermissionURLs(String userName);

}