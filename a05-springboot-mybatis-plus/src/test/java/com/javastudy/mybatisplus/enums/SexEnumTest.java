package com.javastudy.mybatisplus.enums;

import com.javastudy.mybatisplus.mapper.UserMapper;
import com.javastudy.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 罗双
 * @createTime 2023/3/31 17:27
 * @Description
 */
@SpringBootTest
class SexEnumTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void test1() {
        User user = new User();
        user.setUserName("神里绫华");
        user.setAge(20);
        user.setSex(SexEnum.FEMALE);
        userMapper.insert(user);
    }

}