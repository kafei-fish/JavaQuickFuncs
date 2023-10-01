package com.lxl.webcrawler.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author lxl
 * @Date 2022/11/17 9:54
 * <p>@Description: 注意：这里不能用@Data,需手动写gitter，setter
 * reason：与@ConfigurationProperties一起用的时候，配置文件的值不能赋值给对应类属性，属性值均为null</p>
 */
@Configuration
@ConfigurationProperties(prefix = "minio")
public class MinioConfig {

//    private String server;
//
//    private int port;
//
//    private String accessKey;
//
//    private String secretKey;
//
//    // 桶名
//    private String bucket;
//
//    // 统一前缀
//    private String urlPrefix;
//
//    /**
//     * 创建minio连接对象
//     * @return
//     */
//    @Bean
//    public MinioClient minioClient(){
//        return  MinioClient.builder()
//                           .endpoint(server,port,false)
//                           .credentials(accessKey,secretKey)
//                           .build();
//    }
//
//    public void setServer(String server) {
//        this.server = server;
//    }
//
//    public void setPort(int port) {
//        this.port = port;
//    }
//
//    public void setAccessKey(String accessKey) {
//        this.accessKey = accessKey;
//    }
//
//    public void setSecretKey(String secretKey) {
//        this.secretKey = secretKey;
//    }
//
//    public void setBucket(String bucket) {
//        this.bucket = bucket;
//    }
//
//
//    public void setUrlPrefix(String urlPrefix) { this.urlPrefix = urlPrefix; }
//
//    public String getUrlPrefix() {
//        return urlPrefix;
//    }
//
//    public String getServer() {
//        return server;
//    }
//
//    public int getPort() {
//        return port;
//    }
//
//    public String getAccessKey() {
//        return accessKey;
//    }
//
//    public String getSecretKey() {
//        return secretKey;
//    }
//
//    public String getBucket() {
//        return bucket;
//    }
}

