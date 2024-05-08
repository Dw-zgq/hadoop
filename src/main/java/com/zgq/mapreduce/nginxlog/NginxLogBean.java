package com.zgq.mapreduce.nginxlog;

import com.google.common.primitives.Longs;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * @author zhanggaoqiang
 * @version 1.0
 * @ClassName: NginxLogBean
 * @description: TODO
 * @date 2024/5/7 13:38
 */
public class NginxLogBean implements WritableComparable<NginxLogBean> {

    private String type;

    private long status;

    private Double requestTime;

    private Double upstreamResponseTime;

    private String qtime;


    @Override
    public int compareTo(NginxLogBean o) {
        // 倒序排列，从大到小
        return this.requestTime > o.getRequestTime() ? -1 : 1;
    }

    @Override
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.type);
        dataOutput.writeLong(this.status);
        dataOutput.writeDouble(this.requestTime);
        dataOutput.writeDouble(this.upstreamResponseTime);
        dataOutput.writeUTF(this.qtime);

    }

    @Override
    public void readFields(DataInput dataInput) throws IOException {
        this.type = dataInput.readUTF();
        this.status = dataInput.readLong();
        this.requestTime = dataInput.readDouble();
        this.upstreamResponseTime = dataInput.readDouble();
        this.qtime = dataInput.readUTF();
    }

    public NginxLogBean() {
    }

    public NginxLogBean(String type, long status, Double requestTime, Double upstreamResponseTime,String qtime) {
        this.type = type;
        this.status = status;
        this.requestTime = requestTime;
        this.upstreamResponseTime = upstreamResponseTime;
        this.qtime = qtime;
    }

    @Override
    public String toString() {
        return "type='" + type + '\t' + ", status=" + status + '\t' + ", requestTime=" + requestTime + '\t' + ", upstreamResponseTime=" + upstreamResponseTime + '\t' + ", qtime=" + qtime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }

    public Double getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Double requestTime) {
        this.requestTime = requestTime;
    }

    public Double getUpstreamResponseTime() {
        return upstreamResponseTime;
    }

    public void setUpstreamResponseTime(Double upstreamResponseTime) {
        this.upstreamResponseTime = upstreamResponseTime;
    }

    public String getQtime() {
        return qtime;
    }

    public void setQtime(String qtime) {
        this.qtime = qtime;
    }
}
