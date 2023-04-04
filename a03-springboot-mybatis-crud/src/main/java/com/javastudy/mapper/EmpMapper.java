package com.javastudy.mapper;

import com.javastudy.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    //    #{id}  mybatis 提供的
//     #{id}  执行时会将 #{id} 替换为 ? 生成预编译sql 会自动设置参数
//    ${}   直接拼接 sql  有sql注入风险
//    #{ }  性能更高， 更安全
    @Delete("delete from emp where id=#{id}")
    void delete(Integer id);
//    int delete(Integer id);

    //    批量删除
    void deleteByIds(List<Integer> ids);


    //    新增
//    @Options 注解， 框架会自动将生成的主键值， 赋值给emp对象的id
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "VALUES (#{username}, #{name}, #{gender}, #{image}, #{job}, #{entrydate}, #{deptId}, #{createTime}, #{updateTime} )")
    void insert(Emp emp);

    //   更新数据
/*    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, " +
            "entrydate=#{entrydate}, dept_id=#{deptId}, update_time=#{updateTime} " +
            "where id=#{id}")
    void update(Emp emp);*/
    void update(Emp emp);


    //    根据id 查询员工
    @Select("select * from emp where id=#{id}")
    Emp seleteById(Integer id);
    List<Emp> selectByWhere(String name, Short gender, LocalDate startDate, LocalDate endDate);

//    直接查询 dept_id 等 因为名字不一致 没有自动封装
//    方法一
/*    @Select("select id, username, password, name, gender, image, job, entrydate, " +
            "dept_id as deptId, create_time as createTime, update_time as updateTime" +
            " from emp where id=#{id}")
    Emp seleteById(Integer id);*/

    //    方法二
/*    @Results({
            @Result(column = "dept_id", property = "deptId"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    @Select("select * from emp where id=#{id}")
    Emp seleteById(Integer id);*/

//    方案三   ： 开启mybatis的驼峰命名自动映射开关   a_column --> aColumn


    //    条件查询
/*    @Select("select * from emp where name like '%${name}%'  and  gender=#{gender} and " +
            "entrydate between #{startDate} and #{endDate} " +
            "order by update_time desc")
    List<Emp> selectByWhere(String name, short gender, LocalDate startDate, LocalDate endDate);*/

//    mysql中的 concat() 字符串拼接语句
/*    @Select("select * from emp where name like concat('%', #{name}, '%')  and  gender=#{gender} and " +
            "entrydate between #{startDate} and #{endDate} " +
            "order by update_time desc")
    List<Emp> selectByWhere(String name, short gender, LocalDate startDate, LocalDate endDate);*/

}
