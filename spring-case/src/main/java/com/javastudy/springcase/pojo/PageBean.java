package com.javastudy.springcase.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author 罗双
 * @createTime 2023/4/1 15:39
 * @Description 分页查询结果的封装类
 */
@Data
public class PageBean {
    private long total;
    private List rows;
}
