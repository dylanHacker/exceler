package com.dylan.exceler.interfaces.http.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 11:13
 */
@Service
public class FileUtil {

    private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

//    @Autowired
    private CommonConfig commonConfig = new CommonConfig();

    public String UploadFile(String filePath, String key) {

//        CommonConfig commonConfig = new CommonConfig();
        // endpoint以杭州为例，其它region请按实际情况填写
        String endpoint = commonConfig.end_point;
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
        String accessKeyId = commonConfig.access_key_id;
        String accessKeySecret = commonConfig.access_key_secret;
        String bucketName = commonConfig.bucket_name;
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件
        PutObjectResult result = ossClient.putObject(bucketName, key, new File(filePath));
        // 关闭client
        ossClient.shutdown();
        return commonConfig.pre_url + key;
    }

    public String DownloadFile(String key, String folderPath) {
//        CommonConfig commonConfig = new CommonConfig();
        logger.error(String.valueOf(commonConfig == null));
        // endpoint以杭州为例，其它region请按实际情况填写
        String endpoint = commonConfig.end_point;
        // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建
        String accessKeyId = commonConfig.access_key_id;
        String accessKeySecret = commonConfig.access_key_secret;
        String bucketName = commonConfig.bucket_name;
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        File file = new File(folderPath + key);
        // 下载object到文件
        ossClient.getObject(new GetObjectRequest(bucketName, key), file);
        // 关闭client
        ossClient.shutdown();
        return folderPath + key;
    }
}
