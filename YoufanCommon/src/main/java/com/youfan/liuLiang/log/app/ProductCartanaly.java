package com.youfan.liuLiang.log.app;

import java.util.Date;

public class ProductCartanaly {
    private String operatorType;
    private Date dateTime;
    private String dateTimeString;
    private long pv;
    private long uv;
    private long productnums;
    private String groupField;

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTimeString() {
        return dateTimeString;
    }

    public void setDateTimeString(String dateTimeString) {
        this.dateTimeString = dateTimeString;
    }

    public long getPv() {
        return pv;
    }

    public void setPv(long pv) {
        this.pv = pv;
    }

    public long getUv() {
        return uv;
    }

    public void setUv(long uv) {
        this.uv = uv;
    }

    public long getProductnums() {
        return productnums;
    }

    public void setProductnums(long productnums) {
        this.productnums = productnums;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }
}
