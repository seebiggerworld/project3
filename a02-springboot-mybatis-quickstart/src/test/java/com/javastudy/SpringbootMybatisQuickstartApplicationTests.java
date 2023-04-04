package com.javastudy;

import com.javastudy.mapper.UserMapper;
import com.javastudy.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

// springboot 整合单元的注解
@SpringBootTest
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired
   private UserMapper userMapper;
    @Test
    public void testListUser() {
        List<User> list = userMapper.list();
        list.forEach(System.out::println);
    }

}
