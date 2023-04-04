package com.javastudy.mybatisplus.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.apache.ibatis.annotations.Delete;

/**
 * @author 罗双
 * @createTime 2023/3/31 18:57
 * @Description
 */
@Data
@TableName(value = "tb_user")
public class User {

    @TableId
    private Long uid;
    private String userName;
    private Integer age;
    private Integer sex;
    private String email;
    @TableLogic
    private Integer isDelete;
}
