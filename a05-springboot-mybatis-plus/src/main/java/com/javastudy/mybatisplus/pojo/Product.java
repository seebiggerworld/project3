package com.javastudy.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author 罗双
 * @createTime 2023/3/31 16:55
 * @Description
 */
@Data
public class Product {
    @TableId
    private Long id;
    private String name;
    private Integer price;
    @Version  // 用于表示乐观锁版本字段
    private Integer version;

}
