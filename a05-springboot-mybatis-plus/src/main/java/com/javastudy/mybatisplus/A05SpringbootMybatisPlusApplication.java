package com.javastudy.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// @MapperScan  用于扫描 mapper 接口所在的包
public class A05SpringbootMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(A05SpringbootMybatisPlusApplication.class, args);
    }

}
