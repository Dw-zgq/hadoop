package com.zgq.mapreduce.woedcount;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.Job;

import java.io.IOException;

/**
 * @author zhanggaoqiang
 * @version 1.0
 * @ClassName: WordCountDriver
 * @description: TODO
 * @date 2024/5/6 13:58
 */
public class WordCountDriver {

    public static void main(String[] args) throws IOException {
        //1、获取job
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        //2、设置jar包路径
        job.setJarByClass(WordCountDriver.class);
        //3、关联mapper、reducer
        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);
        //4、设置map输入key、v
        //5、设置最终输出的kv
        //6、设置输入、输出路径
        //7、提交job
    }
}
