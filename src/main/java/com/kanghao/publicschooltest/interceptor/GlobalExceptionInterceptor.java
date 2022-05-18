package com.kanghao.publicschooltest.interceptor;

import com.kanghao.publicschooltest.config.CommonResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionInterceptor {

    @ExceptionHandler(Exception.class)
    public CommonResult ExceptionHandler(HttpServletRequest request, Exception e){
        //打印日志  打印异常  返回结果
        e.printStackTrace();

        return CommonResult.fail();
    }
}