package com.youfan.liuLiang.log.app;

import java.util.Date;

public class Diveceanaly {
    private String diveceType;
    private Date dateTime;
    private String dateTimeString;
    private long pv;
    private long uv;
    private long productnums;
    private String groupField;

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }

    public String getDiveceType() {
        return diveceType;
    }

    public void setDiveceType(String diveceType) {
        this.diveceType = diveceType;
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
}
