package com.youfan.liuLiang.log;

public class XiaoChenXuProductHuoDong extends XiaoChenXuDeviceLog{
    private String huodongId;//活动id
    private String scantime;//浏览的时间
    private String jumpTime;//跳出活动的时间

    public String getHuodongId() {
        return huodongId;
    }

    public void setHuodongId(String huodongId) {
        this.huodongId = huodongId;
    }

    public String getScantime() {
        return scantime;
    }

    public void setScantime(String scantime) {
        this.scantime = scantime;
    }

    public String getJumpTime() {
        return jumpTime;
    }

    public void setJumpTime(String jumpTime) {
        this.jumpTime = jumpTime;
    }
}
