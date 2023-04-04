package com.javastudy.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javastudy.mybatisplus.mapper.UserMapper;
import com.javastudy.mybatisplus.pojo.User;
import com.javastudy.mybatisplus.service.UserService;
import org.springframework.stereotype.Service;


/**
 * @author luosh
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
