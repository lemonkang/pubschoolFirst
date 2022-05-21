package com.kanghao.publicschooltest.controller;

import com.kanghao.publicschooltest.config.CommonResult;
import com.kanghao.publicschooltest.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Api("阿里云的图片上传")
@RestController
@CrossOrigin
@RequestMapping("/aliyunoss")
public class OssController {
    @Autowired
    OssService ossService;

    @ApiOperation("阿里云的单张图片上传")
    @PostMapping("/uploadImage")
    public CommonResult uploadImage(@RequestBody(required = true)  MultipartFile uploadfile){
        System.out.println(uploadfile);
        String originalFilename = uploadfile.getOriginalFilename();

        if (uploadfile==null){
            return CommonResult.fail().message("file不能为空");
        }
        String fileurl = ossService.uploadImage(uploadfile);
        return CommonResult.sucess().data("url",fileurl);
    }
    @ApiOperation("阿里云的多张图片上传")
    @PostMapping("/uploadManyImage")
    public CommonResult uploadManyImage(@RequestParam(value = "uploadfiles") MultipartFile[] uploadfiles){
        if (uploadfiles==null){
            return CommonResult.fail().message("file不能为空");
        }
        System.out.println(uploadfiles);
        return CommonResult.sucess();
    }
    @ApiOperation("删除多张图片")
    @DeleteMapping("/uploadManyImage")
    public CommonResult deleteManyImage(@RequestParam(value = "files")List<String> files){
        System.out.println("获取的files数据类型"+files);

        if (files==null){
            return CommonResult.fail().message("file不能为空");
        }
        List list = ossService.deleteImage(files);
        if (list==null || list.size()==0){
            return CommonResult.sucess();
        }
        return CommonResult.fail().data("files",list).message("删除失败，未被删除的数据");
    }

}
