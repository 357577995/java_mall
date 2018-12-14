package com.how2java.tmall.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.tmall.mapper.UserRoleMapper;
import com.how2java.tmall.pojo.Admin;
import com.how2java.tmall.pojo.Role;
import com.how2java.tmall.service.AdminService;
import com.how2java.tmall.service.RoleService;
import com.how2java.tmall.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class justTest {

	@Autowired
	AdminService adminService;
	@Autowired
	UserRoleMapper UserRoleMapper;
	@Autowired
	UserService userService;
	@Autowired
	RoleService roleService;

	@Test
	public void testAdmin() {
		List<Admin> us = adminService.list();

		Map<Admin, List<Role>> user_list = new HashMap<>();

		for (Admin admin : us) {
			List<Role> role = roleService.listRoles(admin);
			user_list.put(admin, role);
		}
		System.out.println(user_list);

	}
}
