package com.alg.userprovide;

import com.alg.common.pojo.User;
import com.alg.userprovide.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class UserProvideApplicationTests {

    @Resource
    private UserDao userDao;

    @Test
    void contextLoads() {

        User u = new User();
        u.setUsername("zhangsan");
        u.setPassword("$2a$10$gExKdT3nkoFKfW1cFlqQUuFji3azHG.W4Pe3/WxHKANg3TpkSJRfW");
        u.setTelephone("15620532538");
        u.setRole("admin");
        userDao.save(u);

    }

}
