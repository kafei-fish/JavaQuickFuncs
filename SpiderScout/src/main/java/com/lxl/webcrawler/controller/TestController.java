package com.lxl.webcrawler.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lxl.webcrawler.entity.LoginBgIconDTO;
import com.lxl.webcrawler.template.MinioServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class TestController {
    

    @Autowired
    private MinioServerImpl minioServer;
    @PostMapping("uploadTest")
    public List<LoginBgIconDTO> loginBgIconDTOS(@RequestParam("files") MultipartFile[] files, @RequestParam("loginBgIcon") String LoginBgIcon) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        // 使用 TypeReference 来指定列表的类型
        List<LoginBgIconDTO> loginBgIconDTOList = objectMapper.readValue(LoginBgIcon, new TypeReference<List<LoginBgIconDTO>>() {});
        List<LoginBgIconDTO> loginBgIconDTOS = minioServer.loginBgIconDTOS(files, loginBgIconDTOList);
        return loginBgIconDTOS;
    }

    public static void main(String[] args) {
        try {
            // 创建ObjectMapper实例
            ObjectMapper objectMapper = new ObjectMapper();

            // 创建包含对象的列表
            List<LoginBgIconDTO> myObjectList = List.of(
                    new LoginBgIconDTO(145232010L, "/aaa/test", 1, 0),
                    new LoginBgIconDTO(1452320145L, "test1.png", 2, 1),
                    new LoginBgIconDTO(null, "test2.png", 3, 3)
            );

            // 将列表转换为JSON字符串
            String jsonString = objectMapper.writeValueAsString(myObjectList);

            // 打印生成的JSON字符串
            System.out.println(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}