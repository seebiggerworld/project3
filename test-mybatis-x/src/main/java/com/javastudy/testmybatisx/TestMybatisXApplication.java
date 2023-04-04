package com.javastudy.testmybatisx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.javastudy.testmybatisx.mapper")
public class TestMybatisXApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMybatisXApplication.class, args);
    }

}
