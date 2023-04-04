package com.javastudy.controller;

import com.javastudy.pojo.Address;
import com.javastudy.pojo.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// @RestController =  @controller +  @ResponseBody
// @RestController 是  @controller 和  @ResponseBody 的组合
// 在类上使用 @RestController 表示这个类中所有的方法都有  @ResponseBody 注解
// 类中所有方法的返回值都会作为 响应数据  （如果是对象 或者是 集合 会先转成json再响应）
@RestController
public class ResponseController {

    //    如果响应数据是 对象或者集合 会先转成json再响应
    @RequestMapping("/hi")
// 统一响应结果
// result
    public Result hello() {
        System.out.println("hello world");
//    return new Result(1, "success", "hello world");
        return Result.success("hello world");
    }

    @RequestMapping("/getAddr")
    public Result getAddr() {
        Address address = new Address("贵州", "铜仁");
        return Result.success(address);
    }

    @RequestMapping("/listAddr")
    public Result listAddr() {
        ArrayList<Address> list = new ArrayList<>();
        Address addr1 = new Address("贵州", "铜仁");
        Address addr2 = new Address("安徽", "合肥");
        list.add(addr1);
        list.add(addr2);
        return Result.success(list);
    }

/*    @RequestMapping("/getAddr")
    public Address getAddr() {
        Address address = new Address("贵州", "铜仁");
        return address;
    }
    @RequestMapping("/listAddr")
    public List<Address> listAddr() {
        ArrayList<Address> list = new ArrayList<>();
        Address addr1 = new Address("贵州", "铜仁");
        Address addr2 = new Address("安徽", "合肥");
        list.add(addr1);
        list.add(addr2);
        return list;
    }*/


}
