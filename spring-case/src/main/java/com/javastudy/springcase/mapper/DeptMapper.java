package com.javastudy.springcase.mapper;

import com.javastudy.springcase.pojo.Dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author luosh
* @description 针对表【dept(部门表)】的数据库操作Mapper
* @createDate 2023-04-01 09:45:42
* @Entity com.javastudy.springcase.pojo.Dept
*/
@Mapper
public interface DeptMapper extends BaseMapper<Dept> {


}




