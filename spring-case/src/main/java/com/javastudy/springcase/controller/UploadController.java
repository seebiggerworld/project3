package com.javastudy.springcase.controller;

import com.javastudy.springcase.pojo.Result;
import com.javastudy.springcase.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author 罗双
 * @createTime 2023/4/1 18:39
 * @Description
 */
@Slf4j
@RestController
public class UploadController {


/*    @PostMapping("/upload")

    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传{},{},{}", username, age, image);
//        存储文件到本地
//        D:\study\backEnd\java\javaSpringBoot\\uploadImages
//        uuid
        String[] split = image.getOriginalFilename().split("\\.");
        String fileName = UUID.randomUUID() + "." + split[split.length - 1];


        log.info("文件名：" + fileName);
        image.transferTo(new File("D:\\study\\backEnd\\java\\javaSpringBoot\\uploadImages\\" + fileName));
        return Result.success();
    }*/

    @Autowired
    AliOSSUtils aliOSSUtils;
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("文件上传， 文件名：" + image.getOriginalFilename());
        // 调用阿里云 oss 工具类上传文件
        String url = aliOSSUtils.upload(image);
        log.info("文件上传完成， 访问该文件的url为：" + url);
        return Result.success(url);
    }


}
