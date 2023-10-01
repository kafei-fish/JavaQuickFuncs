package com.lxl.datasynctool.config;

import com.lxl.datasynctool.entity.LoginBgIconDTO;
import com.lxl.datasynctool.service.TestService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author 李晓龙
 * @version 1.0
 * @description: TODO
 * @date 2023/9/18 21:15
 */
@RestController
public class TestController {


    private TestService testService;
    @PostMapping("uploadTest")
    public List<LoginBgIconDTO> loginBgIconDTOS(@RequestParam("files") MultipartFile[] files, @RequestParam("loginBgIcon") String LoginBgIcon){
        return null;
    }
}
