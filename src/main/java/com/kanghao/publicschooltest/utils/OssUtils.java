package com.kanghao.publicschooltest.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.kanghao.publicschooltest.constant.OssConstant;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class OssUtils {
    // OSSClient实例
    private static OSS ossClient;

    /*
    使用静态代码块创建OSSClient实例
     */
    static {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = OssConstant.ENDPOINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = OssConstant.ACCESS_KEY_ID;
        String accessKeySecret = OssConstant.ACCESS_KEY_SECRET;
        // 创建OSSClient实例。
        ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

    /*
    增加单张图片
     */
    public static String uploadImage(MultipartFile file) {

        // 填写Bucket名称，例如examplebucket。
        String bucketName = OssConstant.BUCKET_NAME;
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String UUID = java.util.UUID.randomUUID().toString().replace("-", "");
        String objectName = file.getOriginalFilename();
        objectName = UUID + objectName;
        try {
            InputStream inputStream = file.getInputStream();
            // 创建PutObject请求。
            ossClient.putObject(bucketName, objectName, inputStream);
            // 这个图片路径需要手动拼接


            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
            // ObjectMetadata metadata = new ObjectMetadata();
            // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            // metadata.setObjectAcl(CannedAccessControlList.Private);
            // putObjectRequest.setMetadata(metadata);

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        String path = "https://" + bucketName + ".oss-cn-shanghai.aliyuncs.com/" + objectName;
        return path;
    }

    /*
    删除单张图片
     */
    public static Boolean deleteImage(String url) {
        //初始化数据是否删除成功
        Boolean isDelete = false;


        // 填写Bucket名称，例如examplebucket。
        String bucketName = OssConstant.BUCKET_NAME;
        // 填写文件完整路径。文件完整路径中不能包含Bucket名称。
        String replacepath = "https://" + bucketName + ".oss-cn-shanghai.aliyuncs.com/";

        String objectName = null;
        if (url != null) {
            String replace = url.replace(replacepath, "");
            objectName = replace;
        }

        try {
            // 删除文件或目录。如果要删除目录，目录必须为空。
            ossClient.deleteObject(bucketName, objectName);
            //  设置删除成功
            isDelete = true;

        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return isDelete;
    }
}
