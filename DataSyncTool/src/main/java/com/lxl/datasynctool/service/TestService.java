package com.lxl.datasynctool.service;

import com.lxl.datasynctool.entity.LoginBgIconDTO;
import org.springblade.core.oss.model.BladeFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李晓龙
 * @version 1.0
 * @description: TODO
 * @date 2023/9/18 19:45
 */
@Service
public class TestService {


    /**
     * @param files           文件
     * @param loginBgIconDTOS 前端
     * @return
     */
    public List<LoginBgIconDTO> loginBgIconDTOS(MultipartFile[] files, List<LoginBgIconDTO> loginBgIconDTOS) {

        Map<String, MultipartFile> fileMap = new HashMap<>();
        for (MultipartFile file : files) {
            fileMap.put(file.getOriginalFilename(), file);
        }
        for (LoginBgIconDTO loginBgIconDTO : loginBgIconDTOS) {
            // 没有改变
            if (loginBgIconDTO.getOperationType() == 0) {
                continue;
            }
            if (fileMap.get(loginBgIconDTO.getPath()) != null){
                loginBgIconDTO.setId(1111L);
                loginBgIconDTO.setPath("上传之后的");
            }
        }
        return loginBgIconDTOS;
    }

    public List<BladeFile> uploadFileGroup(MultipartFile[] files) {
        List<BladeFile> fileNames = new ArrayList<>();
        for (MultipartFile file : files) {
            BladeFile bladeFile = new BladeFile();
            fileNames.add(bladeFile);
        }
        return fileNames;
    }

}
