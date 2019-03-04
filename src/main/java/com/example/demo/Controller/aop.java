package com.example.demo.Controller;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class aop {
    @Pointcut(value = "execution(public * com.example.demo.Controller.test.test())")
    public void aaop(){};
    @Before("aaop()")
    public void me()
    {
        System.out.println("bbbbb");
    }
}
