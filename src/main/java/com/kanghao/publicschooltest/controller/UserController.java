package com.kanghao.publicschooltest.controller;

import com.kanghao.publicschooltest.config.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("单元测试模块")
@RequestMapping("/testdemo")
@RestController
@CrossOrigin
public class UserController {
    @ApiOperation("测试全局异常拦截器")
    @GetMapping("/globalExceptionInterceptor")
    public CommonResult globalExceptionInterceptor(String str)  {
     try {
         Integer num=10/0;
     }catch (Exception e){
         throw e;
     }


        return CommonResult.sucess();
    }

}
