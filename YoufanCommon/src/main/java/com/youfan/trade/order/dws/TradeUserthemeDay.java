package com.youfan.trade.order.dws;

import com.youfan.enums.ThemeType;

import java.util.Date;

/**
 * 交易用户主题
 */
public class TradeUserthemeDay {

    private  long userId;
    private long productTypeId;
    private Date dateTime;
    private int status;
    private long productnums;
    private long shopnumbers;
    private long merchartnumbers;
    private long  numbers ;
    private double totalAmount;


    private String groupField;//分组

    private ThemeType themeType;

    public long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getProductnums() {
        return productnums;
    }

    public void setProductnums(long productnums) {
        this.productnums = productnums;
    }

    public long getShopnumbers() {
        return shopnumbers;
    }

    public void setShopnumbers(long shopnumbers) {
        this.shopnumbers = shopnumbers;
    }

    public long getMerchartnumbers() {
        return merchartnumbers;
    }

    public void setMerchartnumbers(long merchartnumbers) {
        this.merchartnumbers = merchartnumbers;
    }

    public long getNumbers() {
        return numbers;
    }

    public void setNumbers(long numbers) {
        this.numbers = numbers;
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
