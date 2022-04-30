package com.youfan.trade.order.dws;

import com.youfan.enums.ThemeType;

import java.util.Date;

/**
 * 交易商品主题
 */
public class TradeProductthemeDay {


    private  long productId;
    private long productTyId;
    private Date dateTime;
    private int status;
    private long usernums;
    private long  numbers;
    private long shopnumbers;
    private long  merchartnumbers ;

    private ThemeType themeType;

    private String groupField;//分组


    public long getProductTyId() {
        return productTyId;
    }

    public void setProductTyId(long productTyId) {
        this.productTyId = productTyId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
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

    public long getUsernums() {
        return usernums;
    }

    public void setUsernums(long usernums) {
        this.usernums = usernums;
    }

    public long getNumbers() {
        return numbers;
    }

    public void setNumbers(long numbers) {
        this.numbers = numbers;
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
