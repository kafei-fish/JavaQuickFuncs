package com.lxl.wc;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.datastream.SingleOutputStreamOperator;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * @author 李晓龙
 * @version 1.0
 * @description: 流式读取
 * @date 2023/10/1 14:45
 */
public class StreamBathWordCount {
    public static void main(String[] args) throws Exception {

        // 1. 创建流式执行环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        // 2. 读取文件
        DataStreamSource<String> lineStream = env.readTextFile("D:\\IdeaProject\\JavaQuickFuncs\\FlinkTutorial\\words.txt");

        // 3. 转换、分组、求和，得到统计结果
        SingleOutputStreamOperator<Tuple2<String, Long>> sum = lineStream.flatMap((FlatMapFunction<String, Tuple2<String, Long>>) (line, out) -> {

            String[] words = line.split(" ");

            for (String word : words) {
                out.collect(Tuple2.of(word, 1L));
            }
        }).keyBy(data -> data.f0)
                .sum(1);

        // 4. 打印
        sum.print();

        // 5. 执行
        env.execute();
    }
}
