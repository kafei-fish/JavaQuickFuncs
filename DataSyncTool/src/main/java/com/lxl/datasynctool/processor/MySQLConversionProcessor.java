package com.lxl.datasynctool.processor;

/**
 * @author 李晓龙
 * @version 1.0
 * @description: TODO
 * @date 2023/9/17 14:44
 */
public class MySQLConversionProcessor implements SQLConversionProcessor {
    @Override
    public String transformTableStructure(String tableStructure) {
        StringBuilder sb = new StringBuilder();
        if (tableStructure != null) {
            // 获取到换行
            String[] split = tableStructure.split("\n");
            for (String s : split) {
                if (s.contains("DROP TABLE IF EXISTS")) {
                    continue;
                }else if (s.contains("CREATE TABLE")){
                    s = s.replace("CREATE TABLE", "CREATE TABLE IF NOT EXISTS ");
                }
                sb.append(s);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MySQLConversionProcessor mySQLConversionProcessor = new MySQLConversionProcessor();
        String tableStructure = mySQLConversionProcessor.transformTableStructure("/*\n" +
                " Navicat Premium Data Transfer\n" +
                "\n" +
                " Source Server         : 112.124.10.0_3306\n" +
                " Source Server Type    : MySQL\n" +
                " Source Server Version : 80027\n" +
                " Source Host           : 112.124.10.0:3306\n" +
                " Source Schema         : testsync\n" +
                "\n" +
                " Target Server Type    : MySQL\n" +
                " Target Server Version : 80027\n" +
                " File Encoding         : 65001\n" +
                "\n" +
                " Date: 17/09/2023 14:46:23\n" +
                "*/\n" +
                "\n" +
                "SET NAMES utf8mb4;\n" +
                "SET FOREIGN_KEY_CHECKS = 0;\n" +
                "\n" +
                "-- ----------------------------\n" +
                "-- Table structure for target_a\n" +
                "-- ----------------------------\n" +
                "DROP TABLE IF EXISTS `target_a`;\n" +
                "CREATE TABLE `target_a`  (\n" +
                "  `id` int(0) NOT NULL,\n" +
                "  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,\n" +
                "  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;\n" +
                "\n" +
                "-- ----------------------------\n" +
                "-- Table structure for target_b\n" +
                "-- ----------------------------\n" +
                "DROP TABLE IF EXISTS `target_b`;\n" +
                "CREATE TABLE `target_b`  (\n" +
                "  `id` bigint(0) NOT NULL,\n" +
                "  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;\n" +
                "\n" +
                "SET FOREIGN_KEY_CHECKS = 1;\n");
        System.out.println(tableStructure);
    }

    @Override
    public String transformInsertStatement(String insertSql) {
        return null;
    }
}
