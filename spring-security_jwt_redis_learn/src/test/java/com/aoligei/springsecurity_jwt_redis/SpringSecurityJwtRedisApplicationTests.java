package com.aoligei.springsecurity_jwt_redis;

import com.aoligei.springsecurity_jwt_redis.dao.UserDao;
import com.aoligei.springsecurity_jwt_redis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
class SpringSecurityJwtRedisApplicationTests {

    @Resource
    UserDao userDao;
    @Resource
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

        User user = userDao.findUserByUsername("zhangsan");
        redisTemplate.opsForValue().set("key:1",user);
    }

}
