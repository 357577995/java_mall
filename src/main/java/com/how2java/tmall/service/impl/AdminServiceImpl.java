package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.mapper.AdminMapper;
import com.how2java.tmall.pojo.Admin;
import com.how2java.tmall.pojo.AdminExample;
import com.how2java.tmall.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper AdminMapper;

	@Override
	public void add(Admin u) {
		AdminMapper.insert(u);
	}

	@Override
	public void delete(int id) {
		AdminMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void update(Admin u) {
		AdminMapper.updateByPrimaryKeySelective(u);
	}

	@Override
	public Admin get(int id) {
		return AdminMapper.selectByPrimaryKey(id);
	}

	public List<Admin> list() {
		AdminExample example = new AdminExample();
		example.setOrderByClause("id desc");
		return AdminMapper.selectByExample(example);
	}

	@Override
	public boolean isEXist(String user_name) {
		AdminExample example = new AdminExample();
		example.createCriteria().andNameEqualTo(user_name);
		List<Admin> u = AdminMapper.selectByExample(example);
		if (!u.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Admin get(String username, String password) {
		AdminExample example = new AdminExample();
		example.createCriteria().andNameEqualTo(username).andPasswordEqualTo(password);
		List<Admin> u = AdminMapper.selectByExample(example);
		if (!u.isEmpty()) {
			return u.get(0);
		}
		return null;
	}

	@Override
	public Admin getByName(String username) {
		AdminExample example = new AdminExample();
		example.createCriteria().andNameEqualTo(username);
		List<Admin> u = AdminMapper.selectByExample(example);
		if (!u.isEmpty()) {
			return u.get(0);
		}
		return null;

	}
}
