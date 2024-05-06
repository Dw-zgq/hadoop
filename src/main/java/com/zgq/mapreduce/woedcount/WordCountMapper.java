package com.zgq.mapreduce.woedcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @author zhanggaoqiang
 * @version 1.0
 * @ClassName: WordCountMapper
 * @description: TODO
 * @date 2024/5/6 16:46
 */
public class WordCountMapper extends Mapper<Text, IntWritable,Text,IntWritable> {
}
