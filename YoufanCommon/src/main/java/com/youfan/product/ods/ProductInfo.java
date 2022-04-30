package com.youfan.product.ods;

import java.util.Date;

public class ProductInfo {
    private long id;
    private String productName;
    private  long productTypeid;
    private double originalPrice;
    private Date createTime;
    private Date updateTime;
    private long shopid;
    private long merchatid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductTypeid() {
        return productTypeid;
    }

    public void setProductTypeid(long productTypeid) {
        this.productTypeid = productTypeid;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
}
