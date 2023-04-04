package com.javastudy.controller;

import com.javastudy.pojo.Emp;
import com.javastudy.pojo.Result;
import com.javastudy.service.EmpService;
import com.javastudy.service.impl.EmpServiceA;
import com.javastudy.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class EmpController {
/*//    指定bean 注入 empServiceA
    @Qualifier("empServiceA")
    @Autowired
    private EmpService empService;*/

//    @Resource 指定 依赖注入的 bean
    /*
    *  @Autowired 是spring提供的 @Resource 是jdk提供的
    *  @Autowired默认是按照类型注入的 @Resource 默认是按照名称注入的
    *
    * */
    @Resource(name = "empServiceB")
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list() {

//        调用 service 获取数据
        List<Emp> empList = empService.listEmp();
//        响应数据
        return Result.success(empList);
/*        //        加载并解析 emp.xml
//        String file = "springboot-web-quickstart/src/main/resources/emp.xml";
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//        对数据进行转换处理  处理 gender job
//         gender  1 ： 男    ， 2： 女
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


//        响应数据
        return Result.success(empList);*/
    }
}
