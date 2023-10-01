package com.lxl.datasynctool.processor;

/**
 * @author 李晓龙
 * @version 1.0
 * @description: sql转换处理器
 * @date 2023/9/17 14:37
 */
public interface SQLConversionProcessor {

    /***
     * @description  将表结构转成可重复执行的语句
     * @param: tableStructure
     * @throws null
     * @author 李晓龙
     * @date: 2023/09/17/ 14:42:21
     * @return: java.lang.String
     */
    String transformTableStructure(String tableStructure);

    /***
     * @description 插入语句转换
     * @param: insertSql
     * @throws null
     * @author 李晓龙
     * @date: 2023/09/17/ 14:43:31
     * @return: java.lang.String
     */
    String transformInsertStatement(String insertSql);
}
