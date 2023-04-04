package com.javastudy;

import com.javastudy.mapper.EmpMapper;
import com.javastudy.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {
    @Autowired
    EmpMapper empMapper;

    @Test
    public void deleteTest() {
//        int delete = empMapper.delete(16);
//        System.out.println(delete);
        empMapper.delete(16);
    }

    @Test
    public void deleteByIdsTest() {
        List<Integer> ids = List.of(14, 15, 23);
        empMapper.deleteByIds(ids);
    }


    @Test
    public void insertTest() {
        Emp emp = new Emp();
        emp.setUsername("ganyu");
        emp.setName("甘雨");
        emp.setImage("1.jpg");
        emp.setGender((short) 2);
        emp.setJob((short) 2);
        emp.setEntrydate(LocalDate.of(2023, 3, 29));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void updateTest() {
        Emp emp = new Emp();
        emp.setId(23);
        emp.setUsername("wangxiaomei");
        emp.setName("王小美");
        emp.setImage("1.jpg");
        emp.setGender((short) 2);
        emp.setJob((short) 2);
        emp.setEntrydate(LocalDate.of(2023, 3, 29));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);
        empMapper.update(emp);
    }

    @Test
    public void seleteByIdTest() {
        Emp emp = empMapper.seleteById(23);
        System.out.println(emp);

    }

    @Test
    public void seleteByWhereTest() {
//        List<Emp> list = empMapper.selectByWhere("张", (short) 1, LocalDate.of(2010, 1, 1), LocalDate.of(2020, 1, 1));
//        List<Emp> list = empMapper.selectByWhere("张",null, null, null);
//        List<Emp> list = empMapper.selectByWhere("张",(short) 1, null, null);
//        List<Emp> list = empMapper.selectByWhere(null,(short) 1, null, null);
        List<Emp> list = empMapper.selectByWhere(null,null  , null, null);


        list.forEach(System.out::println);
    }

    @Test
    public void updateTest2() {
        Emp emp = new Emp();
        emp.setId(23);
        emp.setUsername("wangxiaomei1112131");
//        emp.setName("王小美111");
//        emp.setImage("1.jpg");
//        emp.setGender((short) 2);
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }
}
