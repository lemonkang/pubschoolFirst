package com.kanghao.ossservice.controller;

import com.kanghao.edubase.config.CommonResult;
import com.kanghao.ossservice.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Api(description = "阿里云图片上传")
@RestController
@RequestMapping("/ossservice")
@CrossOrigin
public class OssController {
    //注入ossService对象
    @Autowired
    private OssService ossService;

    @ApiOperation("上传图片")
    @PostMapping("/uploadImage")
    public CommonResult uploadImage(@RequestBody(required = false) @ApiParam(value = "图片的file文件") MultipartFile file){
        if (file==null)CommonResult.fail().message("图片不能为空");
        String s = ossService.uploadImage(file);
        if (s==null)CommonResult.fail().message("新增失败");
        return CommonResult.success().data("url",s);
    }
    @ApiOperation("删除图片")
    @DeleteMapping ("/deleteImage")
    public CommonResult deleteImage(@RequestBody(required = false) @ApiParam(value = "图片的URL") String url){
         if (url==null)CommonResult.fail().message("url不能为空");
        Boolean deleteImage = ossService.deleteImage(url);

        return CommonResult.success().data("deleteImage",deleteImage);
    }
}
