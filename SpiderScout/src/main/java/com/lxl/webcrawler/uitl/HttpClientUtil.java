package com.lxl.webcrawler.uitl;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author 李晓龙
 * @version 1.0
 * @description: HttpClientUitl 工具类
 * @date 2023/9/9 22:39
 */
public class HttpClientUtil {

    /***
     * @description 发生get请求
     * @param: url 请求url
     * @throws
     * @author 李晓龙
     * @date: 2023/09/09/ 22:40:55
     * @return: java.lang.String
     */
    public static String sendGet(String url) {
        //  创建httpclient对象
        HttpClient client = HttpClients.createDefault();

        // 发送Get请求
        HttpGet get = new HttpGet(url);
        // 执行get
        try {
            HttpResponse response = client.execute(get);
            // 获取请求结果
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            System.out.printf("获取链接失败");
        }
        return null;
    }

}
