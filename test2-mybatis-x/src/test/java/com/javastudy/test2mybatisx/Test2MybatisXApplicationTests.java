package com.javastudy.test2mybatisx;

import com.javastudy.test2mybatisx.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Test2MybatisXApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        System.out.println(userMapper.selectById(1));
    }

}
