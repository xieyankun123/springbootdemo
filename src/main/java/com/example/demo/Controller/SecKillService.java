package com.example.demo.Controller;

import javax.annotation.Resource;

/**
 * 模拟秒杀
 */
public class SecKillService {
    @Resource
    private redisLock redisLock;
    //超时时间10s
    private static final int TIMEOUT = 10 * 1000;

    public void secKill(String productId){
        long time = System.currentTimeMillis() + TIMEOUT;
        //加锁
        if (!redisLock.lock(productId, String.valueOf(time))){

        }

        //具体的秒杀逻辑

        //解锁
        redisLock.unlock(productId, String.valueOf(time));
    }
}
