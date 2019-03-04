package com.example.demo.service.impl;

import com.example.demo.mapper.userMapper;
import com.example.demo.service.userService;
import com.example.demo.en.user;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class luserService implements userService {
    @Resource
    private userMapper userDao;
    @Override
    public List<user> list() {
        return userDao.list();
    }
    public int insert(user u) {
        return userDao.insert(u);
    }

}
