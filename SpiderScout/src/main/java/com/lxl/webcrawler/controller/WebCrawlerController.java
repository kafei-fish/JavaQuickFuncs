package com.lxl.webcrawler.controller;

import com.lxl.webcrawler.server.WebCrawlerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 李晓龙
 * @version 1.0
 * @description: TODO
 * @date 2023/9/10 18:57
 */
@RestController
@RequestMapping("webCrawler")
public class WebCrawlerController {

    @Autowired
    WebCrawlerServer webCrawlerServer;

    @PostMapping("getWebCrawler")
    public String getWebCrawler(@RequestBody String url) throws Exception {
//        CompletableFuture.supplyAsync(() -> webCrawlerServer.sendMsg(url));

        return "开启热搜消息控制";
    }
}
