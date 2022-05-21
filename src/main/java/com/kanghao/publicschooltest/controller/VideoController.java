package com.kanghao.publicschooltest.controller;

import com.kanghao.publicschooltest.config.CommonResult;
import com.kanghao.publicschooltest.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Api(description = "阿里云的视频点播")
@RestController
@CrossOrigin
@RequestMapping("/aliyunvideo")
public class VideoController {
    //注入视频点播业务实现类
    @Autowired
    private VideoService videoService;


    @ApiOperation("上传视频")
    @PostMapping(value = "/uploadVideo",headers = "content-type=multipart/form-data")
    public CommonResult uploadVideo( MultipartFile file) {
        videoService.uploadVideo(file);
        System.out.println(file);
        return CommonResult.sucess();
    }
    @ApiOperation("根据视频ID获取视频URL")
    @PostMapping ("/getUrlByVideoId")
    public CommonResult getUrlByVideoId(@RequestParam(value = "videoId") String videoId){
      String url= videoService.getUrlByVideoId(videoId);
        System.out.println(url);
        return CommonResult.sucess().data("dsaf","asdg");
    }
}
