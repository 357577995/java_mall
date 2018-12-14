package com.how2java.tmall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.tmall.pojo.Role;
import com.how2java.tmall.service.RoleService;
import com.how2java.tmall.util.Page;

@Controller
@RequestMapping("")
public class RoleController {
	@Autowired
	RoleService roleService;

	@RequestMapping("admin_role_list")
	public String list(Model model, Page page) {
		PageHelper.offsetPage(page.getStart(), page.getCount());

		List<Role> us = roleService.list();

		int total = (int) new PageInfo<>(us).getTotal();
		page.setTotal(total);

		model.addAttribute("us", us);
		model.addAttribute("page", page);

		return "admin/listRole";
	}

	@RequestMapping("admin_role_add")
	public String add(Role a) {
		roleService.add(a);
		return "redirect:admin_user_list";
	}


}