package com.javastudy.springcase.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javastudy.springcase.pojo.Dept;
import com.javastudy.springcase.service.DeptService;
import com.javastudy.springcase.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
* @author luosh
* @description 针对表【dept(部门表)】的数据库操作Service实现
* @createDate 2023-04-01 09:45:42
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

    @Autowired
    DeptMapper deptMapper;
    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);
    }
}




