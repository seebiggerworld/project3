package com.javastudy.springcase.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.javastudy.springcase.pojo.Emp;
import com.javastudy.springcase.pojo.PageBean;
import com.javastudy.springcase.pojo.Result;
import com.javastudy.springcase.service.EmpService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/*

* */
/**
 * @author 罗双
 * @createTime 2023/4/1 9:56
 * @Description
 */
@RestController
@RequestMapping("/emps")
@Slf4j
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping
    public Result page(String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean pageBean = empService.getPageBean(name, gender, begin, end, page, pageSize);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result deleteEmps(@PathVariable List<Integer> ids) {
        log.info("delete ids:{}", ids);
        empService.removeByIds(ids);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getEmp(@PathVariable Integer id) {
        log.info("get id:{}", id);
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PostMapping
    public Result addEmp(@RequestBody Emp emp) {
        log.info("add emp:{}", emp);
        empService.addEmp(emp);
        return Result.success();
    }

    @PutMapping
    public Result updateEmp(@RequestBody Emp emp) {
        log.info("修改员工" + emp);
        empService.updateEmp(emp);
        return Result.success();
    }



}
