package com.kanghao.eduservice.controller;

import com.kanghao.edubase.config.CommonResult;
import com.kanghao.eduservice.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController //@controller  @ResponseBody
@CrossOrigin //能够跨域
@RequestMapping("/eduservice")
@Api("用户模块")
public class UserController {

    @GetMapping("/getUserById")
    @ApiOperation("根据ID获取用户信息")
    public User getUserById(@RequestParam("userid") String id){
        System.out.println("获取的数据"+id);
        return null;
    }
    @PostMapping("/inserUser")
    @ApiOperation("增加单个用户")
    public void inserUser(@RequestBody(required = true) User userinfo){
        System.out.println(userinfo.toString());
    }
    @ApiOperation("根据ID删除某个用户")
    @DeleteMapping("/deleteUserById")
    public CommonResult deleteUserById(@RequestBody(required = false) String userinfo){
        System.out.println("根据ID删除某个元素"+userinfo);

       return CommonResult.fail();
    }

}
