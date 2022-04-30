package com.youfan.product.ods;

import java.util.Date;

public class MerchantInfo {
    private long id;
    private String  merchantname;
    private String  merchantdesc;
    private Date createTime;
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
