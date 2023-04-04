package com.javastudy.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author 罗双
 * @createTime 2023/3/31 18:58
 * @Description
 */
@Data
public class Product {
    @TableId
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;
}
