package com.youfan.liuLiang.log.dws;

import com.youfan.enums.ThemeType;

import java.util.Date;

public class UserthemeDay {

    private  String userId;
    private Date dateTime;
    private String deviceType;
    private String  operatorType;
    private long devicenums;
    private long deviceTypenumbers;
    private long operatornumbers;
    private long scanhuodongnums ;
    private long scanproudctnums;
    private long scanproducttypenums;
    private long scanpingdaonums;
    private long scanproducttotal;

    private String groupField;//分组

    private ThemeType themeType;


    public long getDeviceTypenumbers() {
        return deviceTypenumbers;
    }

    public void setDeviceTypenumbers(long deviceTypenumbers) {
        this.deviceTypenumbers = deviceTypenumbers;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public long getOperatornumbers() {
        return operatornumbers;
    }

    public void setOperatornumbers(long operatornumbers) {
        this.operatornumbers = operatornumbers;
    }

    public long getScanhuodongnums() {
        return scanhuodongnums;
    }

    public void setScanhuodongnums(long scanhuodongnums) {
        this.scanhuodongnums = scanhuodongnums;
    }

    public long getScanproudctnums() {
        return scanproudctnums;
    }

    public void setScanproudctnums(long scanproudctnums) {
        this.scanproudctnums = scanproudctnums;
    }

    public long getScanproducttypenums() {
        return scanproducttypenums;
    }

    public void setScanproducttypenums(long scanproducttypenums) {
        this.scanproducttypenums = scanproducttypenums;
    }

    public long getScanpingdaonums() {
        return scanpingdaonums;
    }

    public void setScanpingdaonums(long scanpingdaonums) {
        this.scanpingdaonums = scanpingdaonums;
    }

    public long getScanproducttotal() {
        return scanproducttotal;
    }

    public void setScanproducttotal(long scanproducttotal) {
        this.scanproducttotal = scanproducttotal;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }

    public ThemeType getThemeType() {
        return themeType;
    }

    public void setThemeType(ThemeType themeType) {
        this.themeType = themeType;
    }
}
