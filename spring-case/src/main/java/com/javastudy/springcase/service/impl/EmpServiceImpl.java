package com.javastudy.springcase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javastudy.springcase.pojo.Emp;
import com.javastudy.springcase.pojo.PageBean;
import com.javastudy.springcase.service.EmpService;
import com.javastudy.springcase.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author luosh
 * @description 针对表【emp(员工表)】的数据库操作Service实现
 * @createDate 2023-04-01 09:47:19
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
        implements EmpService {

    @Autowired
    EmpMapper empMapper;


    @Override
    public PageBean getPageBean(String name, Short gender, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        Page<Emp> empPage = new Page<>(page, pageSize);
        LambdaQueryWrapper<Emp> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name), Emp::getName, name)
                .eq(gender != null, Emp::getGender, gender)
                .between(begin != null, Emp::getEntrydate, begin, end)
                .orderByDesc(Emp::getUpdateTime);
        empMapper.selectPage(empPage, queryWrapper);
        PageBean pageBean = new PageBean();
        pageBean.setTotal(empPage.getTotal());
        pageBean.setRows(empPage.getRecords());
        return pageBean;
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    @Override
    public void updateEmp(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);
    }

    @Override
    public Emp login(Emp emp) {
        LambdaQueryWrapper<Emp> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Emp::getUsername, emp.getUsername())
                .eq(Emp::getPassword, emp.getPassword());
        return empMapper.selectOne(queryWrapper);
    }


}




