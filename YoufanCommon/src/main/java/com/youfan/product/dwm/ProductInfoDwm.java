package com.youfan.product.dwm;

import java.util.Date;

public class ProductInfoDwm {
    private  long productTypeid;
    private Date dateTime;
    private String dateTimeString;
    private long shopid;
    private long merchatid;
    private long numbers;
    private long tradenumbes;
    private String groupField;

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }

    public long getProductTypeid() {
        return productTypeid;
    }

    public void setProductTypeid(long productTypeid) {
        this.productTypeid = productTypeid;
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

    public long getShopid() {
        return shopid;
    }

    public void setShopid(long shopid) {
        this.shopid = shopid;
    }

    public long getMerchatid() {
        return merchatid;
    }

    public void setMerchatid(long merchatid) {
        this.merchatid = merchatid;
    }

    public long getNumbers() {
        return numbers;
    }

    public void setNumbers(long numbers) {
        this.numbers = numbers;
    }

    public long getTradenumbes() {
        return tradenumbes;
    }

    public void setTradenumbes(long tradenumbes) {
        this.tradenumbes = tradenumbes;
    }
}
