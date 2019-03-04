package com.example.demo.Controller;

import groovy.util.logging.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import com.example.demo.StringUtils;
import javax.annotation.Resource;

//@Controller
@Slf4j
public class redisLock {
    @Resource
    private StringRedisTemplate redisTemplate;
    /**
     * 加锁
     */
    public boolean lock(String key,String value)
    {
        if(redisTemplate.opsForValue().setIfAbsent(key,value))
        {
            return true;
        }
        //解决死锁，当多个线程同时来时，只让一个线程拿到锁
        String currentValue = redisTemplate.opsForValue().get(key);
        //如果过期
        if (!StringUtils.isEmpty(currentValue) &&
                Long.parseLong(currentValue) < System.currentTimeMillis()){
            //获取上一个锁的时间
            String oldValue = redisTemplate.opsForValue().getAndSet(key, value);
            if (StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return true;
            }
        }
        return false;
    }
    /**
     * 解锁
     * @param key
     * @param value
     */
    public void unlock(String key, String value){

        try {
            String currentValue = redisTemplate.opsForValue().get(key);
            if (!StringUtils.isEmpty(currentValue) && currentValue.equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
        }
    }
}
