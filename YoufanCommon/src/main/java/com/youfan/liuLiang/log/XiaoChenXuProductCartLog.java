package com.youfan.liuLiang.log;

public class XiaoChenXuProductCartLog extends XiaoChenXuDeviceLog {
    private String pindaoId;//频道id
    private String productTypeId;//产品类别id
    private String productId;//产品id
    private String operatorType;//0添加1删除
    private String operatorTime;//操作时间戳


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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(String operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(String operatorTime) {
        this.operatorTime = operatorTime;
    }
}
