package com.youfan.product.app;

import java.util.Date;

public class ProductinfoApp {
    private Date dateTime;
    private String dateTimeString;
    private long productnumbers;//上架商品趋势
    private long producttradenumbes;//上架商品成交趋势
    private long merchantnumbers;//新增商家数趋势
    private long merchantshopnubmers;//新增商家开店数趋势

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

    public long getProductnumbers() {
        return productnumbers;
    }

    public void setProductnumbers(long productnumbers) {
        this.productnumbers = productnumbers;
    }

    public long getProducttradenumbes() {
        return producttradenumbes;
    }

    public void setProducttradenumbes(long producttradenumbes) {
        this.producttradenumbes = producttradenumbes;
    }

    public long getMerchantnumbers() {
        return merchantnumbers;
    }

    public void setMerchantnumbers(long merchantnumbers) {
        this.merchantnumbers = merchantnumbers;
    }

    public long getMerchantshopnubmers() {
        return merchantshopnubmers;
    }

    public void setMerchantshopnubmers(long merchantshopnubmers) {
        this.merchantshopnubmers = merchantshopnubmers;
    }
}
