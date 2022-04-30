package com.youfan.liuLiang.log;

public class XiaoChenxuProductLog extends XiaoChenXuDeviceLog{
    private String productId;//产品id
    private String pindaoId;//频道id
    private String productTypeId;//产品类别id
    private String scantime;//浏览的时间
    private String jumpTime;//跳出商品的时间

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPindaoId() {
        return pindaoId;
    }

    public void setPindaoId(String pindaoId) {
        this.pindaoId = pindaoId;
    }

    public String getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(String productTypeId) {
        this.productTypeId = productTypeId;
    }

    public String getScantime() {
        return scantime;
    }

    public void setScantime(String scantime) {
        this.scantime = scantime;
    }

    public String getJumpTime() {
        return jumpTime;
    }

    public void setJumpTime(String jumpTime) {
        this.jumpTime = jumpTime;
    }
}
