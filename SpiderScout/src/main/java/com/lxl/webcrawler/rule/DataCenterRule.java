package com.lxl.webcrawler.rule;

import org.springblade.core.oss.rule.OssRule;
import org.springframework.stereotype.Component;

/**
 * @author 李晓龙
 * @version 1.0
 * @description: TODO
 * @date 2023/9/14 19:49
 */
@Component
public class DataCenterRule implements OssRule {
    @Override
    public String bucketName(String bucketName) {
        return bucketName;
    }

    @Override
    public String fileName(String originalFilename) {
        return originalFilename;
    }
}
