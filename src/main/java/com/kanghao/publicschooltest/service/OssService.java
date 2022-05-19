package com.kanghao.publicschooltest.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface OssService {
    //增加单张图片
    String uploadImage(MultipartFile file);
    //删除单张图片
    List deleteImage(List<String> files);
}
