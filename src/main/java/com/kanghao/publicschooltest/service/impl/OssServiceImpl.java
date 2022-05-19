package com.kanghao.publicschooltest.service.impl;

import com.kanghao.publicschooltest.service.OssService;
import com.kanghao.publicschooltest.utils.OssUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {
    //增加单张图片
    @Override
    public String uploadImage(MultipartFile file) {
        String s = OssUtils.uploadImage(file);

        return s;
    }

    /*
    删除单张图片
     */
    @Override
    public List deleteImage(List<String> files) {
        ArrayList<String> unDeleteFile = new ArrayList<>();
        files.forEach(item->{
            System.out.println("传输的数据"+item);
            Boolean aBoolean = OssUtils.deleteImage(item);
            if (!aBoolean) unDeleteFile.add(item);
        });

        return unDeleteFile;
    }
}
