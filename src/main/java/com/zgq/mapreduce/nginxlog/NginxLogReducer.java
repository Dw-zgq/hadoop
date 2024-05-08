package com.zgq.mapreduce.nginxlog;

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
public class NginxLogReducer extends Reducer<NginxLogBean, Text , Text,NginxLogBean> {

    @Override
    protected void reduce(NginxLogBean key, Iterable<Text> values,Context
            context) throws InterruptedException, IOException {
        for(Text t:values){
            context.write(t,key);
        }
    }
}
