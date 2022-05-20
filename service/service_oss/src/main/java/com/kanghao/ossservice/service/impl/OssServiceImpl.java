package com.kanghao.ossservice.service.impl;

import com.kanghao.ossservice.service.OssService;
import com.kanghao.ossservice.utils.OssUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class OssServiceImpl implements OssService {


    /**
     * @author kanghao
     * @param file文件
     * @return  返回图片URL
     *
     */
    @Override
    public String uploadImage(MultipartFile file) {
        String s = OssUtils.uploadImage(file);
        return s;
    }

    /**
     *
     * @param  图片的url
     * @return  true 删除成功  false删除失败
     */

    @Override
    public Boolean deleteImage(String url) {
        Boolean isDelete = OssUtils.deleteImage(url);
        return isDelete;
    }


}
