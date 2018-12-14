package com.how2java.tmall.service;

import com.how2java.tmall.pojo.Admin;

import java.util.List;

public interface AdminService {
    void add(Admin u);

    void delete(int id);

    void update(Admin u);

    Admin get(int id);

    List list();

    boolean isEXist(String user_name);

    Admin get(String username, String password);
}
