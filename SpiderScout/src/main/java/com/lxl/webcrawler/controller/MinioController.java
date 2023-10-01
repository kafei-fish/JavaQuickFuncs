package com.lxl.webcrawler.controller;

import com.lxl.webcrawler.template.MinioServerImpl;
import org.springblade.core.oss.MinioTemplate;
import org.springblade.core.oss.model.BladeFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class MinioController {
//
    @Autowired
    private MinioTemplate minioTemplate;

    @Autowired
    MinioServerImpl minioServer;


    /**
     * 单文件上传
     *
     * @param file 文件
     * @return
     */
    @PostMapping("/upload")
    public BladeFile uploadOne(@RequestParam("file") MultipartFile file) {
        BladeFile bladeFile = minioServer.upload(file);
        return bladeFile;
    }


    @PostMapping("test")
    public String test(@RequestBody String name) {

        return name;
    }

    @PostMapping("/uploadFileGroup")
    public List<BladeFile> uploadList(MultipartFile[] files) {
        // 判断 文件是否是唯一的，如果就之前的删除了
        List<BladeFile> uploadList = minioServer.uploadFileGroup(files);
        return uploadList;
    }

    @GetMapping("/deleteFile/{name}")
    public String deleteFileList(@PathVariable String name) {
        minioTemplate.removeFile(name);
        return   "删除成功";
    }


    @GetMapping("/a")
    public String a() {
        return "aaaaa";
    }

//    /**
//     *  单文件下载
//     * @param fileName 文件
//     * @param delete 下载完后是否删除, 请谨慎传参
//     */
//    @GetMapping("/download")
//    public void download(@RequestParam(value = "fileName") String fileName,
//                         @RequestParam(defaultValue = "false")Boolean delete, HttpServletResponse response) {
//        minioTemplate.fileDownload(fileName,delete,response);
//    }
//
////    /**
////     * 查看存储的文件列表
////     * @param bucket 桶
////     * @return
////     */
////    @GetMapping("/list")
////    public  Object fileList(@RequestParam(value = "bucket") String bucket) {
////        return minioTemplate.listObjects(bucket);
////    }
//
//    /**
//     * 删除文件
//     * @param bucket 桶
//     * @param list 文件名列表
//     * @return
//     */
//    @DeleteMapping("/remove")
//    public  Object fileremove(@RequestParam String bucket,@RequestParam List<String> list) {
//        return minioTemplate.removeObjects(bucket,list);
//    }

}
