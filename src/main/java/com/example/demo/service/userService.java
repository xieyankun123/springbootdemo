package com.example.demo.service;
import com.example.demo.en.user;
import java.util.List;

public interface userService {
     List<user> list();
     int insert(user u);
}
