package com.kanghao.publicschooltest.controller;

import com.kanghao.publicschooltest.config.CommonResult;
import com.kanghao.publicschooltest.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Api( description = "单元测试模块")
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
    @ApiOperation("测试接受数组")
    @DeleteMapping("/acceptArray")
    public CommonResult acceptArray(@RequestBody(required =false )HashMap<String,Object> hashMap){
        System.out.println(hashMap);
        return CommonResult.sucess();
    }
    @ApiOperation(("get请求传递基本数据类型"))
    @GetMapping("/getparam")
    public CommonResult getparam(@RequestParam(value = "name") String name,@RequestParam(value = "age") Integer age){
        System.out.println(name);
        System.out.println(age);
        return CommonResult.sucess();
    }
    @ApiOperation(("传递一个对象"))
    @GetMapping("/getobjparam")
    public CommonResult getobjparam(User user){
        System.out.println(user);
        return CommonResult.sucess();
    }
}
