package com.javastudy.mybatisplus.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javastudy.mybatisplus.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * @author 罗双
 * @createTime 2023/3/31 18:56
 * @Description
 */
@Repository
@DS(value = "master")
public interface UserMapper extends BaseMapper<User> {
}
