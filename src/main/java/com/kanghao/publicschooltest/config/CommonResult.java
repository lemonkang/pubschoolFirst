package com.kanghao.publicschooltest.config;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Data
@Component
public class CommonResult {
    private Boolean sucess;
    private Integer code;
    private HashMap<String,Object> data=null;
    private String message=null;
    public  static CommonResult sucess(){
        CommonResult commonResult = new CommonResult();
        commonResult.setSucess(true);
        commonResult.setCode(2000);
        return commonResult;

    }
    public  static CommonResult fail(){
        CommonResult commonResult = new CommonResult();
        commonResult.setSucess(false);
        commonResult.setCode(2001);
        return commonResult;

    }
    public CommonResult data(String key,Object value){
        HashMap<String, Object> objectHashMap = new HashMap<>();
        this.setData(objectHashMap);
        return this;
    }
    public CommonResult message(String message){
        this.setMessage(message);
        return this;
    }
}
