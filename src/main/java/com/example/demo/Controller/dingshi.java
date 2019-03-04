package com.example.demo.Controller;

import com.example.demo.en.user;
import com.example.demo.service.userService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
//@EnableScheduling//开启定时任务
@EnableAsync
public class dingshi {
    @Resource
    private userService userService;
    @Async
    @Scheduled(cron = "0 * * * * *")//
    public void min()
    {
        System.out.println("0");
        userService.insert(new user("xyx","111"));
        System.out.println(new Date());
    }
    @Async
    @Scheduled(cron = "0 * * * * *")//
    public void min1()
    {
        System.out.println("1");
        userService.insert(new user("xyx","111"));
        System.out.println(new Date());
    }
    @Async
    @Scheduled(cron = "0 * * * * *")//
    public void min2()
    {
        System.out.println("2");
        userService.insert(new user("xyx","111"));
        System.out.println(new Date());
    }
    @Async
    @Scheduled(cron = "0 * * * * *")//
    public void min3()
    {
        System.out.println("3");
        userService.insert(new user("xyx","111"));
        System.out.println(new Date());
    }
    @Async
    @Scheduled(cron = "0 * * * * *")//
    public void min4()
    {
        System.out.println("4");
        userService.insert(new user("xyx","111"));
        System.out.println(new Date());
    }
}
