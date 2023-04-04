package com.javastudy.springcase;

import com.javastudy.springcase.mapper.DeptMapper;
import com.javastudy.springcase.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class SpringCaseApplicationTests {

    @Autowired
    DeptMapper deptMapper;
    @Autowired
    EmpMapper empMapper;
    @Test
    void contextLoads() {
        System.out.println(deptMapper.selectById(1));
        System.out.println(empMapper.selectById(1));
    }

    @Test
    void uuid() {
        for (int i = 0; i < 1000; i++) {
            String string = UUID.randomUUID().toString();
            System.out.println(string);
        }
    }



}
