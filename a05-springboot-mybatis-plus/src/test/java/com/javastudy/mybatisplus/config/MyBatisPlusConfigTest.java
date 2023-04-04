package com.javastudy.mybatisplus.config;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javastudy.mybatisplus.mapper.UserMapper;
import com.javastudy.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 罗双
 * @createTime 2023/3/31 16:16
 * @Description
 */
@SpringBootTest
class MyBatisPlusConfigTest {

    @Autowired
    UserMapper userMapper;
    @Test
    void testPage() {
//        current 为当前 页
        Page<User> page = new Page<>(4, 2);
        userMapper.selectPage(page, null);
        System.out.println(page);
       System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
    }

    @Test
    void testPageVo() {
        Page<User> page = new Page<>(2, 3);
        userMapper.selectPageVo(page, 19);
        System.out.println(page.getPages());
    }
}