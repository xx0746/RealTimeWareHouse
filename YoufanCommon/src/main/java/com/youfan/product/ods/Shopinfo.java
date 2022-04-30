package com.youfan.product.ods;

import java.util.Date;

public class Shopinfo {
    private long id;
    private String shopname;
    private String shopdesc;
    private long merchantid;
    private Date createTime;
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(long merchantid) {
        this.merchantid = merchantid;
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
}
