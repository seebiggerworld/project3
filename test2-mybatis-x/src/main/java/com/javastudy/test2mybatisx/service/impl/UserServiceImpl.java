package com.javastudy.test2mybatisx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javastudy.test2mybatisx.pojo.User;
import com.javastudy.test2mybatisx.service.UserService;
import com.javastudy.test2mybatisx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author luosh
 * @description 针对表【tb_user】的数据库操作Service实现
 * @createDate 2023-03-31 20:33:36
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

}




