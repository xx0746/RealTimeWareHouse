package com.youfan.product.dws;

import com.youfan.enums.ThemeType;

import java.util.Date;

public class ProductThemeDws {
    private  long productTypeid;
    private Date dateTime;
    private String dateTimeString;
    private long shopnubmers;
    private long merchatnumbers;
    private long numbers;
    private long tradenumbes;
    private ThemeType themeType;

    private String groupField;

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

    public long getShopnubmers() {
        return shopnubmers;
    }

    public void setShopnubmers(long shopnubmers) {
        this.shopnubmers = shopnubmers;
    }

    public long getMerchatnumbers() {
        return merchatnumbers;
    }

    public void setMerchatnumbers(long merchatnumbers) {
        this.merchatnumbers = merchatnumbers;
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
