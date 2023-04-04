package com.javastudy.springcase.controller;

import com.javastudy.springcase.pojo.Emp;
import com.javastudy.springcase.pojo.Result;
import com.javastudy.springcase.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 罗双
 * @createDateTime 2023/4/4 8:31
 * @Description
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {

        log.info("emp:{}", emp);
       Emp e =  empService.login(emp);
       return e!=null? Result.success():Result.error("用户名或密码错误");

    }
}
