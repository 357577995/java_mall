package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.UserMapper;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.pojo.UserExample;
import com.how2java.tmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void add(User u) {
        userMapper.insert(u);
    }

    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(User u) {
        userMapper.updateByPrimaryKeySelective(u);
    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> list() {
        UserExample example = new UserExample();
        example.setOrderByClause("id desc");
        return userMapper.selectByExample(example);
    }

    @Override
    public boolean isEXist(String user_name) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(user_name);
        List<User> u = userMapper.selectByExample(example);
        if (!u.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public User get(String username, String password) {
        UserExample example = new UserExample();
        example.createCriteria().andNameEqualTo(username).andPasswordEqualTo(password);
        List<User> u = userMapper.selectByExample(example);
        if (!u.isEmpty()) {
            return u.get(0);
        }
        return null;
    }
}
