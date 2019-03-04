package com.example.demo.mapper;

import com.example.demo.en.user;
import java.util.List;
public interface userMapper {
    int deleteByPrimaryKey(Integer id);
    List<user> list();
    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}