package com.javastudy.controller;

import com.javastudy.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

// @RestController =  @controller +  @ResponseBody
// @RestController 是  @controller 和  @ResponseBody 的组合
// 在类上使用 @RestController 表示这个类中所有的方法都有  @ResponseBody 注解
// 类中所有方法的返回值都会作为 响应数据  （如果是对象 或者是 集合 会先转成json再响应）
@RestController
public class RequestController {
    @RequestMapping("/request")

    public String getRequest(String name, Integer age) {
        System.out.println(name + age);
        return "ok";
    }

    @RequestMapping("simplePojo")
    public String simplePojo(User user) {
        System.out.println(user);
        return "ok";
    }

    @RequestMapping("complexPojo")
    public String complexPojo(User user) {
        System.out.println(user);
        return "ok";
    }

    @RequestMapping("arrayParam")
//    数组名要与参数名保存一致
    public String arrayParam(String[] hobby) {
        System.out.println(Arrays.toString(hobby));
        return "ok";
    }

    @RequestMapping("listParam")
//    集合名要与参数名保存一致
//    还要加  @RequestParam  注解
    public String listParam(@PathVariable List<String> hobby) {
        System.out.println(hobby);
        return "ok";
    }

    @RequestMapping("dataParam")
    public String dataParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime) {
        System.out.println(updateTime);
        return "ok";
    }

    @RequestMapping("jsonParam")
//    json格式的封装
//    需要用 @RequestBody 将json格式的数据封装到实体类中
    public String jsonParam(@RequestBody User user) {
        System.out.println(user);
        return "ok";
    }

    //    获取路径参数
//    用 注解  @PathVariable
    @RequestMapping("/path/{id}")
    public String pathParam(@PathVariable Integer id) {
        System.out.println(id);
        return "ok";
    }

    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id, @PathVariable String name) {
        System.out.println(id + ":" + name);
        return "ok";
    }


}
