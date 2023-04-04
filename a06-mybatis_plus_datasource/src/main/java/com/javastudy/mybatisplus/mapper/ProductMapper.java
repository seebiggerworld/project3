package com.javastudy.mybatisplus.mapper;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.javastudy.mybatisplus.pojo.Product;
import org.springframework.stereotype.Repository;

/**
 * @author 罗双
 * @createTime 2023/3/31 18:58
 * @Description
 */
@Repository
@DS(value = "slave_1")
public interface ProductMapper extends BaseMapper<Product> {
}
