package com.javastudy.springcase.controller;

import com.javastudy.springcase.mapper.DeptMapper;
import com.javastudy.springcase.pojo.Dept;
import com.javastudy.springcase.pojo.Result;
import com.javastudy.springcase.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author 罗双
 * @createTime 2023/4/1 9:52
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    DeptService deptService;

    //   下列代码 用 @Slf4j 代替
    //  private static Logger log = (Logger) LoggerFactory.getLogger(DeptController.class);

    // @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result getDepts() {
        List<Dept> depts = deptService.list();
        return Result.success(depts);
    }

    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable Integer id) {
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result updateDept(@RequestBody Dept dept) {
        log.info("updateDept: " + dept);
        deptService.updateDept(dept);
        return Result.success();

    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Integer id) {
        deptService.removeById(id);
        return Result.success();
    }

    @PostMapping
    public Result addDept(@RequestBody Dept dept) {
        log.info("addDept: {}", dept);
         deptService.addDept(dept);
         return Result.success();
    }




}
