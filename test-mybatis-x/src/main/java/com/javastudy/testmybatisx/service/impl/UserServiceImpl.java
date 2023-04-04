package com.javastudy.testmybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javastudy.testmybatisx.pojo.User;
import com.javastudy.testmybatisx.service.UserService;
import com.javastudy.testmybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author luosh
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2023-03-31 19:57:25
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




