package com.zgq.mapreduce.nginxlog;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @author zhanggaoqiang
 * @version 1.0
 * @ClassName: WordCountDriver
 * @description: TODO
 * @date 2024/5/6 13:58
 */
public class NginxLogDriver {

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        //1、获取job
        Configuration configuration = new Configuration();
        Job job = Job.getInstance(configuration);
        //2、设置jar包路径
        job.setJarByClass(NginxLogDriver.class);
        //3、关联mapper、reducer
        job.setMapperClass(NginxLogMapper.class);

        //4、设置map输入key、v
        job.setMapOutputKeyClass(NginxLogBean.class);
        job.setMapOutputValueClass(Text.class);
        //5、设置最终输出的kv
        job.setReducerClass(NginxLogReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NginxLogBean.class);
        //6、设置输入、输出路径
        FileInputFormat.setInputPaths(job,new Path("/Users/zhanggaoqiang/file/hadoop-input"));
        FileOutputFormat.setOutputPath(job,new Path("/Users/zhanggaoqiang/file/hadoop-output666"));
        //7、提交job
        job.waitForCompletion(true);
    }
}
