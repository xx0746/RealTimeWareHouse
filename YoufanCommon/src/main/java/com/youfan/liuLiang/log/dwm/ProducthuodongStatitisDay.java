package com.youfan.liuLiang.log.dwm;

import com.youfan.enums.YeWuType;

import java.util.Date;

public class ProducthuodongStatitisDay {
    private String userId;
    private Date scanTime;
    private String deviceType;
    private String deviceId;
    private String huodongId;
    private long scantimes;
    private long scanTimetotals;
    private long avgTime;
    private String groupField;

    private YeWuType yeWuType;

    public YeWuType getYeWuType() {
        return yeWuType;
    }

    public void setYeWuType(YeWuType yeWuType) {
        this.yeWuType = yeWuType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getScanTime() {
        return scanTime;
    }

    public void setScanTime(Date scanTime) {
        this.scanTime = scanTime;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getHuodongId() {
        return huodongId;
    }

    public void setHuodongId(String huodongId) {
        this.huodongId = huodongId;
    }

    public long getScantimes() {
        return scantimes;
    }

    public void setScantimes(long scantimes) {
        this.scantimes = scantimes;
    }

    public long getScanTimetotals() {
        return scanTimetotals;
    }

    public void setScanTimetotals(long scanTimetotals) {
        this.scanTimetotals = scanTimetotals;
    }

    public long getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(long avgTime) {
        this.avgTime = avgTime;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }
}
