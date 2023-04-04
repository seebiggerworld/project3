package com.javastudy.testmybatisx.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.javastudy.testmybatisx.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
* @author luosh
* @description 针对表【tb_user】的数据库操作Mapper
* @createDate 2023-03-31 19:57:25
* @Entity com.javastudy.testmybatisx.pojo.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

   int insertSelective(User user);

    int deleteByUidAndUserName(@Param("uid") Long uid, @Param("userName") String userName);

    int updateAgeAndUserNameByUid(@Param("age") Integer age, @Param("userName") String userName, @Param("uid") Long uid);

    List<User> selectAgeAndUserNameByAgeBetween(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

    List<User> selectAllOrderByAgeDesc();
}




