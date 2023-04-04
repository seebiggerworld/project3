package com.javastudy.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.javastudy.mybatisplus.mapper")
public class A06MybatisPlusDatasourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(A06MybatisPlusDatasourceApplication.class, args);
    }

}
