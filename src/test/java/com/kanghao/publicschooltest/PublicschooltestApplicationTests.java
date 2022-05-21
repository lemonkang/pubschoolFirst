package com.kanghao.publicschooltest;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.kanghao.publicschooltest.constant.OssConstant;
import com.kanghao.publicschooltest.utils.OssUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootTest
class PublicschooltestApplicationTests {
/*
阿里云上传
 */
    @Test
    void uploadOss() {
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = OssConstant.ENDPOINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = OssConstant.ACCESS_KEY_ID;
        String accessKeySecret = OssConstant.ACCESS_KEY_SECRET;
        // 填写Bucket名称，例如examplebucket。
        String bucketName = OssConstant.BUCKET_NAME;
        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        String objectName = "imagepa.png";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        String filePath= "D:\\image\\pa.png";
        try {
            InputStream inputStream = new FileInputStream(filePath);
            // 创建PutObject请求。
            ossClient.putObject(bucketName, objectName, inputStream);

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
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }
    /*
    随机生成UUID
     */
    @Test
    public void RandomUUid(){
        System.out.println(UUID.randomUUID().toString().replace("-", "").toLowerCase());
    }
    /*
    在try中执行return方法，会不会执行finall中的方法
     */
    @Test
    public void testtry(){
        try {
            System.out.println("执行try方法");
            return;
        }catch (Exception e){

        }finally {
            System.out.println("finall中的方法");
        }
    }
    /*
    删除单个文件
     */
    @Test
    public void deletesinglepicture(){
        // Endpoint以华东1（杭州）为例，其它Region请按实际情况填写。
        String endpoint = OssConstant.ENDPOINT;
        // 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = OssConstant.ACCESS_KEY_ID;
        String accessKeySecret = OssConstant.ACCESS_KEY_SECRET;
        // 填写Bucket名称，例如examplebucket。
        String bucketName = OssConstant.BUCKET_NAME;
        // 填写文件完整路径。文件完整路径中不能包含Bucket名称。
        String objectName = "test.txt";
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            // 删除文件或目录。如果要删除目录，目录必须为空。
            ossClient.deleteObject(bucketName, objectName);
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
    }
    /*
    测试replace方法
     */
    @Test
    public void strreplace(){
        String str="test";
        String te = str.replace("te", "");
        System.out.println(str);
        System.out.println(te);
    }
    /*
    遍历元素，增加元素
     */
    @Test
    public void foreach(){
        ArrayList<String> strings = new ArrayList<>();
        strings.add("sad");
        strings.add("sdaf");
        strings.add("dgfasdg");
        ArrayList<String> deletearrs = new ArrayList<>();
        strings.stream().forEach(item->{
            System.out.println(item);

        });

    }
    /*
    删除单个图片
     */
    @Test
    public void deleteImage(){
        Boolean aBoolean = OssUtils.deleteImage("https://publicschoolfirst.oss-cn-shanghai.aliyuncs.com/pa.png");
        System.out.println(aBoolean);
    }
    /**
     * 本地文件上传
     */
    @Test
    public void localUpload(){

    }

}
