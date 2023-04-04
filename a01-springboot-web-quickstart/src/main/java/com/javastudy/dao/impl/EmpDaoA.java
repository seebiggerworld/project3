package com.javastudy.dao.impl;

import com.javastudy.dao.EmpDao;
import com.javastudy.pojo.Emp;
import com.javastudy.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

// ioc  inversion of control  控制反转
//DI dependency injection  依赖注入
// 将当前类 交给 IOC 容器管理， 成为IOC容器中的bean
//@Component
// @Repository 是 @Component 注解在 dao 类上的衍生
//bean的名字  默认值是类名首字母小写
//bean的名字 也可以通过 value 自己指定
//bean的名字 一般情况下使用默认值
@Repository//("daoA")
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        //        加载并解析 emp.xml
//        String file = "springboot-web-quickstart/src/main/resources/emp.xml";
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
