package com.javastudy.mybatisplus.mapper;

import com.javastudy.mybatisplus.pojo.User;
import net.sf.jsqlparser.util.validation.metadata.NamedObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserMapperTest {

    @Autowired
//    @Autowired 使实体类自动装配  但是UserMapper是一个接口  所有会误报
//    在UserMapper上加@Repository注解可解决
    private UserMapper userMapper;


//    查询所有数据
    @Test
    public void testSelectList() {
//        通过条件构造器 查询一个 list集合  没条件 null
        userMapper.selectList(null).forEach(System.out::println);
    }


    //    插入
    @Test
    public void testInsert() {
        User user = new User();
        user.setUserName("甘雨2");
        user.setAge(19);
        user.setEmail("ganyu@studyjava.com");
        int result = userMapper.insert(user);
        System.out.println("result:" + result);
//        id 由 雪花算法生成
        System.out.println("id:" + user.getUid());
    }


//    删除
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(1641610287146663938L);
        System.out.println("result:" + result);

    }

//    批量删除
    @Test
    public void deleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "甘雨");
        map.put("age", 19);
//       ==>  Preparing: DELETE FROM user WHERE name = ? AND age = ?
//       ==> Parameters: 甘雨(String), 19(Integer)
//        根据标记删除
        int result = userMapper.deleteByMap(map);
        System.out.println("result:" + result);

    }

    //    通过多个id 进行批量删除
    @Test
    public void testDeleteBatchIds() {
        List<Long> list = new ArrayList<>();
        Collections.addAll(list, 5L, 6L);
        int result = userMapper.deleteBatchIds(list);
        System.out.println("result:" + result);
    }

    @Test
    public void testUpdateById() {
        User user = new User();
        user.setUid(1L);
        user.setUserName("甘雨");
        user.setAge(19);
        user.setEmail("ganyu@studyjava.com");
        int result = userMapper.updateById(user);
        System.out.println("result:" + result);
    }

    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds() {
        List<Long> list = new ArrayList<>();
        Collections.addAll(list, 3L, 4L);
        List<User> users = userMapper.selectBatchIds(list);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "甘雨");
        map.put("age", 19);
//        SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectMapById() {
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);
    }


}