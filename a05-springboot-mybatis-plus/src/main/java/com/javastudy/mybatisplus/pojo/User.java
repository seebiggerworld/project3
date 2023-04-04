package com.javastudy.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.javastudy.mybatisplus.enums.SexEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author luosh
 */
@Data
//设置实体类所对应的表名
//@TableName("tb_user")
public class User {
//    将属性对应的字段指定为主键
//    type = IdType.AUTO  设置主键自动递增
//    设置自动递增时， 数据库也必须是 自动递增才能起作用
    @TableId(value = "uid", type = IdType.AUTO)
    private Long uid;
    // 设置 普通字段 对应关系
    @TableField(value = "user_name")
    private String userName;
    private Integer age;
    private String email;
    private SexEnum sex;
    // @TableLogic 逻辑删除
    @TableLogic
    private Integer isDelete;
}
