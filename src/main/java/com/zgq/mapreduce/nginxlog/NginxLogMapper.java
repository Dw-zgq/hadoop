package com.zgq.mapreduce.nginxlog;

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
public class NginxLogMapper extends Mapper<LongWritable, Text, NginxLogBean,Text > {



//    IntWritable v = new IntWritable(1);
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        String string = value.toString();
        //'$remote_addr - $remote_user [$time_local] "$request" '
        // '$status $body_bytes_sent $request_time $upstream_response_time "$http_referer" '
        // '"$http_user_agent" "$http_x_forwarded_for"';

        //10.3.183.54 - - [03/May/2024:04:04:33 +0800] "POST /gl/CIT-BMS/api/v1/smgs/allManager HTTP/1.1"
        // 200 5318 2.854 2.854 "-" "python-requests/2.28.1" "94.247.129.174, 39.96.119.141"
        //10.3.183.57 0
        // - 1
        // - 2
        // [03/May/2024:04:04:33 3
        // +0800] 4
        // "POST 5
        // /gl/CIT-BMS/api/v1/smgs/allManager 6
        // HTTP/1.1" 7
        // 200 8
        // 324 9
        // 1.436 10
        // 1.435 11
        // "-" "python-requests/2.28.1" "94.247.129.174, 39.96.130.63"
        Text k = new Text();
        String[] strings = string.split(" ");
        System.out.println(strings[5]+">>>"+strings[6]+">>>"+strings[8]+">>>"+strings[10]+">>>"+strings[11]+">>>"+strings[3]);
        k.set(strings[6].split("\\?")[0]);
        NginxLogBean nginxLogBean = new NginxLogBean();
        if ("-".equals(strings[11])){
            nginxLogBean = new NginxLogBean(strings[5],Long.parseLong(strings[8]),Double.parseDouble(strings[10]),Double.parseDouble("0"),strings[3]);
        }else {
            nginxLogBean = new NginxLogBean(strings[5],Long.parseLong(strings[8]),Double.parseDouble(strings[10]),Double.parseDouble(strings[11]),strings[3]);
        }
        context.write(nginxLogBean,k);

        /*for (String s : strings) {
            if ( s.length() > 3  &&"/gl".equals(s.substring(0,3))){
                k.set(s.split("\\?")[0]);
                context.write(k,v);
            }
        }*/

    }


}
