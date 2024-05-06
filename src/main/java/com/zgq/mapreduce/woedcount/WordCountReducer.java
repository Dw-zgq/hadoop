package com.zgq.mapreduce.woedcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author zhanggaoqiang
 * @version 1.0
 * @ClassName: WordCountReducer
 * @description: TODO
 * @date 2024/5/6 16:46
 */
public class WordCountReducer extends Reducer<Text, IntWritable,Text,IntWritable> {


    int sum;
    IntWritable v = new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,Context
            context) throws InterruptedException, IOException {

// 1 累加求和
        sum = 0;
        for (IntWritable count : values) {
            sum += count.get();
        }
// 2 输出
        v.set(sum);
        context.write(key,v);

    }
}
