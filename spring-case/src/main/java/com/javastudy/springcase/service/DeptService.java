package com.javastudy.springcase.service;

import com.javastudy.springcase.pojo.Dept;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author luosh
* @description 针对表【dept(部门表)】的数据库操作Service
* @createDate 2023-04-01 09:45:42
*/
public interface DeptService extends IService<Dept> {

    /**
    * @Description: 添加部门
    * @Param: [dept]
    * @return: void
    * @Author: Luosh

     */
    void addDept(Dept dept);

    void updateDept(Dept dept);
}
