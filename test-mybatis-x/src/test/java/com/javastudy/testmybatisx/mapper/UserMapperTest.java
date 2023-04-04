package com.javastudy.testmybatisx.mapper;

import com.javastudy.testmybatisx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 罗双
 * @createTime 2023/3/31 20:19
 * @Description
 */
@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    void test() {
        List<User> users = userMapper.selectAllOrderByAgeDesc();
        users.forEach(System.out::println);
    }

    @Test
    void test2() {
        System.out.println(userMapper.selectById(1));
    }

}