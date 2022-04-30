package com.youfan.trade.order.app;

import java.util.Date;

public class TradeApp {
    private long productTypeId;
    private Date dateTime;
    private String dateTimeString;
    private long usernumser;//订单用户数
    private long ordernumbers;//订单数
    private double totalAmount;//总金额
    private long productnumser;//成交商品数
    private String gourpField;//分组条件

    public String getGourpField() {
        return gourpField;
    }

    public void setGourpField(String gourpField) {
        this.gourpField = gourpField;
    }

    public long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
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

    public long getUsernumser() {
        return usernumser;
    }

    public void setUsernumser(long usernumser) {
        this.usernumser = usernumser;
    }

    public long getOrdernumbers() {
        return ordernumbers;
    }

    public void setOrdernumbers(long ordernumbers) {
        this.ordernumbers = ordernumbers;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getProductnumser() {
        return productnumser;
    }

    public void setProductnumser(long productnumser) {
        this.productnumser = productnumser;
    }
}
