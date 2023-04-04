package com.javastudy.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javastudy.mybatisplus.mapper.UserMapper;
import com.javastudy.mybatisplus.pojo.User;
import com.javastudy.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 罗双
 * @createTime 2023/3/31 19:10
 * @Description
 */
@DS(value = "master")
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
