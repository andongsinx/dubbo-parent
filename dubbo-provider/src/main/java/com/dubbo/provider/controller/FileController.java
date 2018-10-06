package com.dubbo.provider.controller;

import com.dubbo.provider.utils.FastDfsUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @description
 * @create by shadow
 * @date 2018/7/6
 * @since 1.0
 */
@RestController
@RequestMapping("/file")
public class FileController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String uploadFile(@RequestParam("uploadFile") MultipartFile uploadFile, HttpServletRequest httpServletRequest){
        String originalFilename = uploadFile.getOriginalFilename();
        String result = "";
        try {
            byte[] bytes = IOUtils.toByteArray(uploadFile.getInputStream());
            result = new FastDfsUtils().uploadFile(bytes, originalFilename, null);
        }catch (Exception e){
            LOGGER.error("上传文件出错...");
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value="/uploadAliyunFile",method=RequestMethod.POST)
    public String uploadAliyunFile(@RequestParam("uploadFile")MultipartFile uploadFile){


        return "success";
    }

    public static void main(String[] args) {
       String str = new String("11");
        System.out.println(str.hashCode());

    }




}
