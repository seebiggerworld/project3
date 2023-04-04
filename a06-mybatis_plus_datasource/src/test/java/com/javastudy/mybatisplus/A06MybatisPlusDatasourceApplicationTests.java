package com.javastudy.mybatisplus;

import com.javastudy.mybatisplus.mapper.ProductMapper;
import com.javastudy.mybatisplus.mapper.UserMapper;
import com.javastudy.mybatisplus.pojo.Product;
import com.javastudy.mybatisplus.pojo.User;
import com.javastudy.mybatisplus.service.ProductService;
import com.javastudy.mybatisplus.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.SocketTimeoutException;

@SpringBootTest
class A06MybatisPlusDatasourceApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    UserMapper userMapper;
    @Autowired
    ProductMapper productMapper;

    @Test
    void test1() {
        User user = userService.getById(1);
        System.out.println("user = " + user);
        Product product = productService.getById(1);
        System.out.println("product = " + product);
    }

    @Test
    void test2() {
        System.out.println(userMapper.selectById(1));
        System.out.println(productMapper.selectById(1));
    }

}
