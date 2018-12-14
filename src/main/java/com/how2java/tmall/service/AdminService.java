package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Admin;

public interface AdminService {
	void add(Admin u);

	void delete(int id);

	void update(Admin u);

	Admin get(int id);

	List<Admin> list();

	boolean isEXist(String user_name);

	Admin get(String username, String password);

	Admin getByName(String userName);
}
