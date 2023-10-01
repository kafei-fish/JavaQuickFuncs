package com.lxl.webcrawler.entity;

import lombok.Data;

/**
 * @author 李晓龙
 * @version 1.0
 * @description: 新闻VO类
 * @date 2023/9/10 12:00
 */
@Data
public class News {
    private String top;
    private String img;
    private String title;
    private String content;
    private String url;
    private String level;
}
