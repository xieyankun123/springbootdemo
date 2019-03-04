package com.example.demo.Controller;

import com.example.demo.en.user;
import com.example.demo.service.RedisService;
import com.example.demo.service.userService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("test")
@ResponseBody
public class test {
    @Resource
    private userService userService;

    @RequestMapping("/1")

    public List<user> test() {
        return userService.list();
    }
    @Resource
    private RedisService redisService;
    //http://localhost:8888/saveCity?cityName=北京&cityIntroduce=中国首都&cityId=1
    @PostMapping(value = "saveCity")

    public String saveCity(int id,String username,String password){
        user u = new user(username,password);
        redisService.set(id+"",u);
        return "success";
    }
    //http://localhost:8888/getCityById?cityId=1
    @PostMapping(value = "getCityById")
    public user getCity(int id){
        user u=(user)redisService.get(id+"");
        System.out.println("1");
        return u;
    }
}

