package com.youfan.liuLiang.log.dws;

import com.youfan.enums.ThemeType;

import java.util.Date;

public class ProductthemeDay {

    private  String productId;
    private Date dateTime;
    private String deviceType;
    private String  operatorType;
    private long devicenums;
    private long  operatornums;
    private long scanproducttotal;
    private long  scanproducttotaltime ;
    private long  scanproductavgtime ;
    private long usernums;
    private ThemeType themeType;

    private String groupField;//分组


    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public long getDevicenums() {
        return devicenums;
    }

    public void setDevicenums(long devicenums) {
        this.devicenums = devicenums;
    }

    public long getOperatornums() {
        return operatornums;
    }

    public void setOperatornums(long operatornums) {
        this.operatornums = operatornums;
    }

    public long getScanproducttotal() {
        return scanproducttotal;
    }

    public void setScanproducttotal(long scanproducttotal) {
        this.scanproducttotal = scanproducttotal;
    }

    public long getScanproducttotaltime() {
        return scanproducttotaltime;
    }

    public void setScanproducttotaltime(long scanproducttotaltime) {
        this.scanproducttotaltime = scanproducttotaltime;
    }

    public long getScanproductavgtime() {
        return scanproductavgtime;
    }

    public void setScanproductavgtime(long scanproductavgtime) {
        this.scanproductavgtime = scanproductavgtime;
    }

    public long getUsernums() {
        return usernums;
    }

    public void setUsernums(long usernums) {
        this.usernums = usernums;
    }

    public ThemeType getThemeType() {
        return themeType;
    }

    public void setThemeType(ThemeType themeType) {
        this.themeType = themeType;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }
}
