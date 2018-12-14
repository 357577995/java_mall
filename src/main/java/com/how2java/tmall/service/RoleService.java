package com.how2java.tmall.service;

import java.util.List;
import java.util.Set;

import com.how2java.tmall.pojo.Admin;
import com.how2java.tmall.pojo.Role;

public interface RoleService {
	public Set<String> listRoleNames(String userName);

	public List<Role> listRoles(String userName);

	public List<Role> listRoles(Admin user);

	public List<Role> list();

	public void add(Role role);

	public void delete(Integer id);

	public Role get(Integer id);

	public void update(Role role);

}