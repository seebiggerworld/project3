package com.javastudy.mapper;

import com.javastudy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

// @Mapper 注解
// 在运行时， 会自动生成该接口的实现类对象（代理对象）
//并且将该对象交给 IOC 容器
@Mapper
public interface UserMapper {
    @Select("select * from user")
    List<User> list();

}
