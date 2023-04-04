package com.javastudy.service.impl;

import com.javastudy.dao.EmpDao;
import com.javastudy.pojo.Emp;
import com.javastudy.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

//@Component
//@Primary
@Service
public class EmpServiceB implements EmpService {
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
                emp.setGender("男士");
            }else if ("2".equals(gender)){
                emp.setGender("女士");
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
