package com.kanghao.publicschooltest.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * 阿里云视频点播业务接口
 * @author 康浩
 */
public interface VideoService {
    /**
     * 视频上传
     * @param file
     */
    String uploadVideo(MultipartFile file);
    /**
     * 根据ID获取URL
     */
     String  getUrlByVideoId(String videoId);
}
