package com.javastudy.mybatisplus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javastudy.mybatisplus.mapper.ProductMapper;
import com.javastudy.mybatisplus.pojo.Product;
import com.javastudy.mybatisplus.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author 罗双
 * @createTime 2023/3/31 19:14
 * @Description
 */
@DS(value = "slave_1")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
