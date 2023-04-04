package com.javastudy.mybatisplus.service;

import com.javastudy.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author 罗双
 * @createTime 2023/3/31 13:02
 * @Description
 */
@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetCount() {
//        查询总记录数
        long count = userService.count();
        System.out.println(count);
    }

    @Test
    public void testInsertMore() {
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserName("甘雨" + i);
            user.setAge(18  + i%3 );
            user.setEmail(i + "ganyu.edu.com");
            list.add(user);
        }
//        批量添加
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }


}