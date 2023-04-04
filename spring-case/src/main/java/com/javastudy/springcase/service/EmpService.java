package com.javastudy.springcase.service;

import com.javastudy.springcase.pojo.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javastudy.springcase.pojo.PageBean;

import java.time.LocalDate;

/**
* @author luosh
* @description 针对表【emp(员工表)】的数据库操作Service
* @createDate 2023-04-01 09:47:19
*/
public interface EmpService extends IService<Emp> {


    PageBean getPageBean(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    void addEmp(Emp emp);

    void updateEmp(Emp emp);

    Emp login(Emp emp);
}
