package com.kanghao.publicschooltest.service.impl;

import com.kanghao.publicschooltest.service.VideoService;
import com.kanghao.publicschooltest.utils.AliyunVideoUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * 阿里云视频点播业务层实现类
 * @author kanghao
 *
 */
@Service
public class VideoServiceImpl implements VideoService {

    /**
     * 视频上传
     * @param file
     */
    @Override
    public String uploadVideo(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String title="测试视频";
        InputStream inputStream=null;
        try {
            inputStream  = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = AliyunVideoUtils.testUploadStream(title, fileName, inputStream);
        return s;


    }

    /**
     * 根据视频ID获取URL
     * @param videoId
     * @return
     */
    @Override
    public String getUrlByVideoId(String videoId) {
        String videoUrl = AliyunVideoUtils.getVideoUrl(videoId);
        return videoUrl;
    }
}
