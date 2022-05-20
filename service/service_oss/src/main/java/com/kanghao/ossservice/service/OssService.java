package com.kanghao.ossservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface OssService {
    //阿里云图片上传
    public String uploadImage(MultipartFile file);
    //阿里云图片删除
    public Boolean deleteImage(String url);
}
