package com.javastudy.service.impl;

import com.javastudy.dao.EmpDao;
import com.javastudy.dao.impl.EmpDaoA;
import com.javastudy.pojo.Emp;
import com.javastudy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
// @Service 是 @Component 注解在 dao 类上的衍生
// @Primary 依赖注入的优先级  让当前这个bean 生效
//@Primary
@Service
public class EmpServiceA implements EmpService {
//DI dependency injection  依赖注入
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {

        List<Emp> empList = empDao.listEmp();
        empList.stream().forEach(emp ->
        {
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            }else if ("2".equals(gender)){
                emp.setGender("女");
            }
//        处理 job  1：讲师   2： 班主任  3：就业指导
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            }else if ("2".equals(job)){
                emp.setJob("班主任");
            }else if ("3".equals(job)){
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}
