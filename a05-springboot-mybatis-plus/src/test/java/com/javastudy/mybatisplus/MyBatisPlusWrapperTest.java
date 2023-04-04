package com.javastudy.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.javastudy.mybatisplus.mapper.UserMapper;
import com.javastudy.mybatisplus.pojo.User;
import com.javastudy.mybatisplus.service.UserService;
import net.minidev.json.writer.UpdaterMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/**
 * @author 罗双
 * @createTime 2023/3/31 14:10
 * @Description
 */
@SpringBootTest
public class MyBatisPlusWrapperTest {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;

    @Test
    public void test01() {
//      查询用户名包含 6 ， 年龄 18 -19之间 邮箱不为空
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        SELECT uid,user_name,age,email,is_delete FROM tb_user
//        WHERE is_delete=0 AND (user_name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
        queryWrapper.like("user_name", "6")
                .between("age", 18, 19)
                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
//    条件构造器组装 排序查询

    @Test
    public void test02() {
//        查询用户信息 按照年龄的降序排序, 若年龄相同 则按照 id 升序排序
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("age").orderByAsc("uid");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test03() {
//        删除 邮箱 为 null 的数据
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        int delete = userMapper.delete(queryWrapper);
        System.out.println(delete);
    }

    //    修改
    @Test
    public void test04() {
        //将（年龄大于20并且用户名中包含有6)或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20).like("user_name", "6")
                .or()
                .isNull("email");
        User user = new User();
        user.setUserName("申鹤");
        user.setEmail("shenhe@edu.cn");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);
    }

    //    修改
    @Test
    public void test05() {
        //将（年龄大于20或邮箱为null）并且用户名中包含有6的用户信息修改
//        lambda 中的条件优先执行
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        "gt" 表示 "greater than"，即大于的意思。在数学或编程中，通常使用符号 ">" 来表示大于。
//        UPDATE tb_user SET user_name=?, email=? WHERE is_delete=0
//        AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        queryWrapper.like("user_name", "6")
                .and(userQueryWrapper ->
                        userQueryWrapper.gt("age", 20)
                                .or().isNull("email"));
        User user = new User();
        user.setUserName("心海");
        user.setEmail("xinhai@edu.cn");
        int update = userMapper.update(user, queryWrapper);
        System.out.println(update);
    }

    @Test
    public void test06() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("user_name", "age", "email")
                .gt("age", 20);

        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);

    }

    @Test
    public void test07() {
//        子查询
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        SELECT uid,user_name,age,email,is_delete FROM tb_user WHERE is_delete=0
//        AND (uid IN (select uid from tb_user where uid<=10))
        queryWrapper.inSql("uid", "select uid from tb_user where uid<=10");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    //    updateWrapper
    @Test
    public void test08() {


        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
//        UPDATE tb_user SET user_name=?,email=?
//        WHERE is_delete=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        updateWrapper.like("user_name", "6")
                .and(userQueryWrapper -> userQueryWrapper.gt("age", 20)
                        .or().isNull("email"));
        updateWrapper.set("user_name", "夜兰").set("email", "yelan@edu.cn");
        int update = userMapper.update(null, updateWrapper);
        System.out.println(update);
    }

    //    动态 sql
    @Test
    public void test09() {
        String username = "6";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)) {
//            isNotBlank  判断某个字符串 是否不为空字符串， 不为null 不为空白符
            queryWrapper.like("user_name", username);
        }
        if (ageBegin != null) {
            queryWrapper.gt("age", ageBegin);
        }
        if (ageEnd != null) {
            queryWrapper.le("age", ageEnd);
        }
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void test10() {
        String username = "6";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "user_name", username)
                .gt(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }

    @Test
    public void test11() {
        String username = "6";
        Integer ageBegin = null;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), User::getUserName, username)
                .gt(ageBegin!= null, User::getAge, ageBegin)
                .le(ageEnd!= null, User::getAge, ageEnd);
        userMapper.selectList(queryWrapper).forEach(System.out::println);
    }
    //    updateWrapper
    @Test
    public void test12() {


        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
//        UPDATE tb_user SET user_name=?,email=?
//        WHERE is_delete=0 AND (user_name LIKE ? AND (age > ? OR email IS NULL))
        updateWrapper.like(User::getUserName, "6")
                .and(userQueryWrapper -> userQueryWrapper.gt(User::getAge, 20)
                        .or().isNull(User::getEmail));
        updateWrapper.set(User::getUserName, "夜兰").set(User::getEmail, "yelan@edu.cn");
        int update = userMapper.update(null, updateWrapper);
        System.out.println(update);
    }
}

