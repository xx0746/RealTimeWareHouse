package com.youfan.liuLiang.log.dwm;

import com.youfan.enums.YeWuType;

import java.util.Date;

public class ProductStatitisDay {
    private String userId;
    private Date scanTime;
    private String deviceType;
    private String deviceId;
    private String pindaoId;
    private String productTypeId;
    private String productId ;
    private String groupField;
    private long scantimes;
    private long scanTimetotals;
    private long avgTime;
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

    public String getPindaoId() {
        return pindaoId;
    }

    public void setPindaoId(String pindaoId) {
        this.pindaoId = pindaoId;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
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
}
