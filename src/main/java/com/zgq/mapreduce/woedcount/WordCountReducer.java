package com.zgq.mapreduce.woedcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @author zhanggaoqiang
 * @version 1.0
 * @ClassName: WordCountReducer
 * @description: TODO
 * @date 2024/5/6 16:46
 */
public class WordCountReducer extends Reducer<Text, IntWritable,Text,IntWritable> {
}
