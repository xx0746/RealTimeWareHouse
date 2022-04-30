package com.youfan.liuLiang.log.dwm;

import com.youfan.enums.YeWuType;

import java.util.Date;

public class ProductCartStatitisDay {
    private String userId;
    private Date operatorTimedate;
    private String deviceType;
    private String deviceId;
    private String pindaoId;
    private String productTypeId;
    private String productId ;
    private String  operatorType;
    private long operatorTimes;
    private String groupField;

    private YeWuType yeWuType;

    public YeWuType getYeWuType() {
        return yeWuType;
    }

    public void setYeWuType(YeWuType yeWuType) {
        this.yeWuType = yeWuType;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getOperatorTimedate() {
        return operatorTimedate;
    }

    public void setOperatorTimedate(Date operatorTimedate) {
        this.operatorTimedate = operatorTimedate;
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

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public long getOperatorTimes() {
        return operatorTimes;
    }

    public void setOperatorTimes(long operatorTimes) {
        this.operatorTimes = operatorTimes;
    }
}
