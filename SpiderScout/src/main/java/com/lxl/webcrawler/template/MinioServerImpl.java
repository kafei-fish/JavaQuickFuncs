package com.lxl.webcrawler.template;

import com.lxl.webcrawler.entity.LoginBgIconDTO;
import com.lxl.webcrawler.entity.ViewContentType;
import org.springblade.core.oss.MinioTemplate;
import org.springblade.core.oss.model.BladeFile;
import org.springblade.core.oss.props.OssProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 *
 */
@Component
public class MinioServerImpl {

    @Autowired
    MinioTemplate ossTemplate;

    @Autowired
    OssProperties ossProperties;

//    @Autowired
//    private MinioClient minioClient;
//
//    @Value("${minio.bucket}")
//    public String bucketName;
//
//    @Value("${minio.urlprefix}")
//    public String urlprefix;
//
//    /**
//     * 判断bucket是否存在，不存在则创建
//     * @param name
//     */
//    public void existBucket(String name){
//        try {
//            boolean exist = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
//            if(!exist){
//                minioClient.makeBucket(MakeBucketArgs.builder().bucket(name).build());
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 创建存储bucket
//     * @param bucketName 存储bucket名称
//     * @return Boolean
//     */
//    public Boolean makeBucket(String bucketName) {
//        try {
//            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }

    public BladeFile upload(MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            return ossTemplate.putFile(ossProperties.getBucketName(), file.getOriginalFilename(), inputStream, ViewContentType.getContentType(file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
            return new BladeFile();
        }
    }

    public List<BladeFile> uploadFileGroup(MultipartFile[] files) {
        List<BladeFile> fileNames = new ArrayList<>();
        for (MultipartFile file : files) {
            BladeFile bladeFile = upload(file);
            fileNames.add(bladeFile);
        }
        return fileNames;
    }

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
                loginBgIconDTO.setId(UUID.randomUUID().getLeastSignificantBits());
                BladeFile upload = upload(fileMap.get(loginBgIconDTO.getPath()));
                loginBgIconDTO.setPath(upload.getOriginalName());
            }
        }
        return loginBgIconDTOS;
    }

//
//    /**
//     * 删除存储bucket
//     * @param bucketName 存储bucket名称
//     * @return Boolean
//     */
//    public Boolean removeBucket(String bucketName) {
//        try {
//            minioClient.removeBucket(RemoveBucketArgs.builder()
//                    .bucket(bucketName)
//                    .build());
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//        return true;
//    }
//
//    /**
//     * 文件上传
//     * @param file
//     * @return
//     */
//    public Map<String, String> upload(MultipartFile file) {
//
//        String filename = FileUtils.extractUploadFilename(file);
//        try {
//            InputStream inputStream = file.getInputStream();
//            // 上传到minio服务器
//            minioClient.putObject(PutObjectArgs.builder()
//                    .bucket(this.bucketName)
//                    .object(filename)
//                    .contentType(ViewContentType.getContentType(filename))
//                    .stream(inputStream, -1L, 10485760L)
//                    .build());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        // 返回地址
//        Map<String,String > resultMap = new HashMap<>();
//        resultMap.put("url",filename);
//        return  resultMap;
//    }
//
//    /**
//     * 文件下载
//     * @param fileName 文件名
//     * @param delete   是否删除
//     * @throws IOException
//     */
//    public void fileDownload(@RequestParam(name = "fileName") String fileName,
//                             @RequestParam(defaultValue = "false") Boolean delete,
//                             HttpServletResponse response) {
//
//            InputStream inputStream   = null;
//            OutputStream outputStream = null;
//            try {
//                if (StringUtils.isBlank(fileName)) {
//                response.setHeader("Content-type", "text/html;charset=UTF-8");
//                String data = "文件下载失败";
//                OutputStream ps = response.getOutputStream();
//                ps.write(data.getBytes("UTF-8"));
//                return;
//            }
//
//            outputStream = response.getOutputStream();
//            // 获取文件对象
//            inputStream =minioClient.getObject(GetObjectArgs.builder().bucket(this.bucketName).object(fileName).build());
//            byte buf[] = new byte[1024];
//            int length = 0;
//            response.reset();
//            response.setHeader("Content-Disposition", "attachment;filename=" +
//                    URLEncoder.encode(fileName.substring(fileName.lastIndexOf("/") + 1), "UTF-8"));
//            response.setContentType("application/octet-stream");
//            response.setCharacterEncoding("UTF-8");
//            // 输出文件
//            while ((length = inputStream.read(buf)) > 0) {
//                outputStream.write(buf, 0, length);
//            }
//            inputStream.close();
//            // 判断：下载后是否同时删除minio上的存储文件
//            if (BooleanUtils.isTrue(delete)) {
//                minioClient.removeObject(RemoveObjectArgs.builder().bucket(this.bucketName).object(fileName).build());
//            }
//        } catch (Throwable ex) {
//            response.setHeader("Content-type", "text/html;charset=UTF-8");
//            String data = "文件下载失败";
//            try {
//                OutputStream ps = response.getOutputStream();
//                ps.write(data.getBytes("UTF-8"));
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//        } finally {
//            try {
//            outputStream.close();
//            if (inputStream != null) {
//                    inputStream.close();
//                }}catch (IOException e){
//                e.printStackTrace();
//            }
//        }
//    }
//
//
////    /**
////     * 查看文件对象
////     * @param bucketName 存储bucket名称
////     * @return 存储bucket内文件对象信息
////     */
////    public List<ObjectItem> listObjects(String bucketName) {
////        Iterable<Result<Item>> results = minioClient.listObjects(ListObjectsArgs.builder().bucket(bucketName).build());
////        List<ObjectItem> objectItems = new ArrayList<>();
////        try {
////            for (Result<Item> result : results) {
////                Item item = result.get();
////
////                ObjectItem objectItem = new ObjectItem();
////                objectItem.setObjectName(item.objectName());
////                objectItem.setSize(item.size());
////
////                objectItems.add(objectItem);
////            }
////        } catch (Exception e) {
////            e.printStackTrace();
////            return null;
////        }
////        return objectItems;
////    }
//
//    /**
//     * 批量删除文件对象
//     * @param bucketName 存储bucket名称
//     * @param objects 对象名称集合
//     */
//    public Map<String, String> removeObjects(String bucketName, List<String> objects) {
//        Map<String,String > resultMap = new HashMap<>();
//        List<DeleteObject> dos = objects.stream().map(e -> new DeleteObject(e)).collect(Collectors.toList());
//        try {
//             minioClient.removeObjects(RemoveObjectsArgs.builder().bucket(bucketName).objects(dos).build());
//            resultMap.put("mes","删除成功");
//        }catch (Exception e){
//            e.printStackTrace();
//            resultMap.put("mes","网络异常，删除失败");
//        }
//        return resultMap;
//    }

}


