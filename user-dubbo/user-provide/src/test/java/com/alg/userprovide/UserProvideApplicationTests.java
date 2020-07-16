package com.alg.userprovide;

import com.alg.common.pojo.User;
import com.alg.userprovide.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@SpringBootTest
class UserProvideApplicationTests {

    @Resource
    private UserDao userDao;

    @Test
    void contextLoads() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            User u = new User();
            u.setUsername("zhangsan"+i);
            u.setPassword("$2a$10$gExKdT3nkoFKfW1cFlqQUuFji3azHG.W4Pe3/WxHKANg3TpkSJRfW");
            u.setTelephone(i+"");
            u.setRole("admin"+i);
            list.add(u);
            userDao.save(u);
        }

    }

}
