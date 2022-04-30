package com.youfan.product.ods;

import java.util.Date;

public class ProductTypeInfo {
    private long  id;
    private String  producttypeName;
    private int productTypeleave;
    private long  parentId;
    private Date createTime;
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
