package com.kanghao.edubase.config;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
@Data
public class CommonResult {
    private Boolean sucess;
    private Integer code;
    private HashMap<String,Object> data=null;
    private  String message=null;
    public static CommonResult success(){
        CommonResult commonResult = new CommonResult();
        commonResult.code=2000;
        commonResult.setSucess(true);
        return commonResult;
    }
    public static CommonResult fail(){
        CommonResult commonResult = new CommonResult();
        commonResult.code=2001;
        commonResult.setSucess(false);
        return commonResult;
    }
    public CommonResult data(String key,Object value){
        HashMap<String, Object> map = new HashMap<>();
        map.put(key, value);
        this.setData(map);
        return this;
    }
    public CommonResult message(String message){
        this.setMessage(message);
        return this;
    }

}
