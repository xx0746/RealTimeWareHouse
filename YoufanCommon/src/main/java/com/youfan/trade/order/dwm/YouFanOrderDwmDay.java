package com.youfan.trade.order.dwm;

import java.util.Date;

/**
 * 订单初步汇总天表
 */
public class YouFanOrderDwmDay {
    private long  userId;
    private long productId;
    private long producttypeId;
    private long shopId;
    private Date timeDate;
    private String timeDateString;
    private long merchartId;
    private int orderstatus;
    private int paystatus;
    private int payType ;
    private long numbers;
    private double orderAmountTotal;
    private double  orderAmountAvg;
    private double payAmountTotal;
    private double payAmountAvg;

    private String groupField;//分组


    public long getProducttypeId() {
        return producttypeId;
    }

    public void setProducttypeId(long producttypeId) {
        this.producttypeId = producttypeId;
    }

    public Date getTimeDate() {
        return timeDate;
    }

    public void setTimeDate(Date timeDate) {
        this.timeDate = timeDate;
    }

    public String getTimeDateString() {
        return timeDateString;
    }

    public void setTimeDateString(String timeDateString) {
        this.timeDateString = timeDateString;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getMerchartId() {
        return merchartId;
    }

    public void setMerchartId(long merchartId) {
        this.merchartId = merchartId;
    }

    public int getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(int orderstatus) {
        this.orderstatus = orderstatus;
    }

    public int getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(int paystatus) {
        this.paystatus = paystatus;
    }

    public int getPayType() {
        return payType;
    }

    public void setPayType(int payType) {
        this.payType = payType;
    }

    public long getNumbers() {
        return numbers;
    }

    public void setNumbers(long numbers) {
        this.numbers = numbers;
    }

    public double getOrderAmountTotal() {
        return orderAmountTotal;
    }

    public void setOrderAmountTotal(double orderAmountTotal) {
        this.orderAmountTotal = orderAmountTotal;
    }

    public double getOrderAmountAvg() {
        return orderAmountAvg;
    }

    public void setOrderAmountAvg(double orderAmountAvg) {
        this.orderAmountAvg = orderAmountAvg;
    }

    public double getPayAmountTotal() {
        return payAmountTotal;
    }

    public void setPayAmountTotal(double payAmountTotal) {
        this.payAmountTotal = payAmountTotal;
    }

    public double getPayAmountAvg() {
        return payAmountAvg;
    }

    public void setPayAmountAvg(double payAmountAvg) {
        this.payAmountAvg = payAmountAvg;
    }
}
