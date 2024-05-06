package com.zgq.mapreduce.woedcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author zhanggaoqiang
 * @version 1.0
 * @ClassName: WordCountMapper
 * @description: TODO
 * @date 2024/5/6 16:46
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {


    Text k = new Text();
    IntWritable v = new IntWritable(1);
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String string = value.toString();

        String[] strings = string.split(" ");

        for (String s : strings) {
            k.set(s);
            context.write(k,v);
        }

    }


}
