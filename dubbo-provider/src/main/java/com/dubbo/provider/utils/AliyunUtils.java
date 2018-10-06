package com.dubbo.provider.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.PutObjectResult;

import java.io.*;
import java.util.Properties;

/**
 * @description
 * @create by shadow
 * @date 2018/7/11
 * @since 1.0
 */

public class AliyunUtils {

    private static final String ALIYUN_CONFIG = "aliyun.properties";

    private static String aliyunEndpoint;

    private static String aliyunAccessKeyId;

    private static String aliyunAccessKeySecret;

    private static String bucketName;

    static {
        Properties pros = new Properties();
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(ALIYUN_CONFIG);
        try {
            pros.load(is);
            aliyunEndpoint = pros.getProperty("aliyun.endpoint");
            aliyunAccessKeyId = pros.getProperty("aliyun.accessKeyId");
            aliyunAccessKeySecret = pros.getProperty("aliyun.accessKeySecret");
            bucketName = pros.getProperty("aliyun.bucketName");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != pros) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static void upload(String fileName, InputStream is) {
        OSSClient ossClient = new OSSClient(aliyunEndpoint, aliyunAccessKeyId, aliyunAccessKeySecret);
        //  ossClient.createBucket(bucketName);
        PutObjectResult putObjectResult = ossClient.putObject(bucketName, fileName, is);
        System.out.println("eTag"+putObjectResult.getETag());
        System.out.println("requestId"+putObjectResult.getRequestId());
        System.out.println("clientCRC"+putObjectResult.getClientCRC());
        System.out.println("serverCRC"+putObjectResult.getServerCRC());
        shutdownClient(ossClient);
    }

    public static void shutdownClient(OSSClient ossClient) {
        if (ossClient != null) {
            ossClient.shutdown();
        }
    }

    public static void main(String[] args) throws  Exception{
        File file = new File("F:\\ideaProject\\rpc\\dubbo-parent\\dubbo-provider\\src\\main\\resources\\img\\test1.jpg");
        InputStream is = new FileInputStream(file);
        AliyunUtils.downloadFile("testOss.jpg", file);
    }


    public static void downloadFile(String fileName,File file) throws Exception{
        OSSClient ossClient = new OSSClient(aliyunEndpoint, aliyunAccessKeyId, aliyunAccessKeySecret);
        OSSObject ossObject = ossClient.getObject(bucketName,fileName);
        InputStream is = ossObject.getObjectContent();
        OutputStream os = new FileOutputStream("F:\\ideaProject\\rpc\\dubbo-parent\\dubbo-provider\\src\\main\\resources\\img\\test2.jpg");
        byte[] buff = new byte[1024];
        if(is !=null){
            while (is.read(buff)!=-1){
                os.write(buff);
                os.flush();
            }
        }
    }

}

