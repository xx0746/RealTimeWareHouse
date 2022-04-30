package com.youfan.product.dwd;

import java.util.Date;

public class ProductInfoDwd {
    private long id;
    private String productName;
    private  long productTypeid;
    private String  producttypeName;
    private int productTypeleave;
    private long  parentId;
    private double originalPrice;
    private Date createTime;
    private Date updateTime;
    private long shopid;
    private String shopname;
    private String shopdesc;
    private long merchatid;
    private String  merchantname;
    private String  merchantdesc;





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

    public String getProducttypeName() {
        return producttypeName;
    }

    public void setProducttypeName(String producttypeName) {
        this.producttypeName = producttypeName;
    }

    public int getProductTypeleave() {
        return productTypeleave;
    }

    public void setProductTypeleave(int productTypeleave) {
        this.productTypeleave = productTypeleave;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
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

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }

    public String getShopdesc() {
        return shopdesc;
    }

    public void setShopdesc(String shopdesc) {
        this.shopdesc = shopdesc;
    }

    public long getMerchatid() {
        return merchatid;
    }

    public void setMerchatid(long merchatid) {
        this.merchatid = merchatid;
    }

    public String getMerchantname() {
        return merchantname;
    }

    public void setMerchantname(String merchantname) {
        this.merchantname = merchantname;
    }

    public String getMerchantdesc() {
        return merchantdesc;
    }

    public void setMerchantdesc(String merchantdesc) {
        this.merchantdesc = merchantdesc;
    }
}
