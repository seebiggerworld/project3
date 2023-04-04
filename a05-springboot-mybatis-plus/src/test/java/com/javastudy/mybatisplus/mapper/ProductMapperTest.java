package com.javastudy.mybatisplus.mapper;

import com.javastudy.mybatisplus.pojo.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 罗双
 * @createTime 2023/3/31 16:59
 * @Description
 */
@SpringBootTest
class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

    @Test
    void test1() {
//        小李查询
        Product product1 = productMapper.selectById(1);
        System.out.println("小李查询的价格" + product1.getPrice());
        //        小wang查询
        Product product2 = productMapper.selectById(1);
        System.out.println("小wang查询的价格" + product2.getPrice());

//        小李修改  + 50
        product1.setPrice(product1.getPrice() + 50);
        productMapper.updateById(product1);
        //        小wang修改   - 30
        product2.setPrice(product2.getPrice() - 30);
        int result = productMapper.updateById(product2);
        if (result == 0) {
//            操作失败重试
            Product product = productMapper.selectById(1);
            product.setPrice(product.getPrice() - 30);
            int i = productMapper.updateById(product);
            System.out.println("xiaowang修改：" + i);
        }

//        老板查询
        //        小wang查询
        Product product3 = productMapper.selectById(1);
        System.out.println("小李查询的价格" + product3.getPrice());
    }

}