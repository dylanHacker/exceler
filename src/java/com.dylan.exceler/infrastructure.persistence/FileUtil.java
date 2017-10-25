package com.dylan.exceler.infrastructure.persistence;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.dylan.exceler.application.config.CommonConfig;

import java.io.File;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 11:13
 */
public class FileUtil {

    public static String UploadFile(String filePath, String key) {

        CommonConfig commonConfig = new CommonConfig();
        // endpoint以杭州为例，其它region请按实际情况填写
        String endpoint = commonConfig.getEnd_point();
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
        String accessKeyId = commonConfig.getAccess_key_id();
        String accessKeySecret = commonConfig.getAccess_key_secret();
        String bucketName = commonConfig.getBucket_name();
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件
        PutObjectResult result = ossClient.putObject(bucketName, key, new File(filePath));
        // 关闭client
        ossClient.shutdown();
        return commonConfig.getPre_url() + key;
    }

    public static String DownloadFile(String key, String folderPath) {
        CommonConfig commonConfig = new CommonConfig();
        // endpoint以杭州为例，其它region请按实际情况填写
        String endpoint = commonConfig.getEnd_point();
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
        String accessKeyId = commonConfig.getAccess_key_id();
        String accessKeySecret = commonConfig.getAccess_key_secret();
        String bucketName = commonConfig.getBucket_name();
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 下载object到文件
        ossClient.getObject(new GetObjectRequest(bucketName, key), new File(folderPath + key));
        // 关闭client
        ossClient.shutdown();
        return folderPath + key;
    }
}
