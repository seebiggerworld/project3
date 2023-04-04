package com.javastudy.springcase.mapper;

import com.javastudy.springcase.pojo.Emp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

/**
* @author luosh
* @description 针对表【emp(员工表)】的数据库操作Mapper
* @createDate 2023-04-01 09:47:19
* @Entity com.javastudy.springcase.pojo.Emp
*/
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

}




