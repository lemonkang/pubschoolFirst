package com.kanghao.eduservice.controller;

import com.kanghao.edubase.config.CommonResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Api("测试接口模块")
@RestController
@CrossOrigin
@RequestMapping("/test")
public class TestController {
    /*
    统一结果返回值测试
     */
    @ApiOperation("测试统一结果返回值-成功")
    @GetMapping("/commonresult")
    public CommonResult testcommonresult(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("234");
        strings.add("fsadf");

        return  CommonResult.success().data("users",strings);
    }
    /*
    测试全局异常拦截器
     */
    @ApiOperation("全局异常拦截器")
    @DeleteMapping("/globalException")
    public CommonResult globalException(){
  try {
      Integer num=10/0;
  }catch (Exception e){
      e.printStackTrace();
  }
        return  null;
    }
}
