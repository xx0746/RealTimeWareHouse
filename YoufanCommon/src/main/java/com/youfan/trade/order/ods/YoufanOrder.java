package com.youfan.trade.order.ods;

import java.util.Date;

public class YoufanOrder {
    private long id;
  private long  userId;
    private long  productId;
  private long  productTypeId;
    private long  merchartId;
    private long shopId;
  private double orderAmount;
    private double  payAmount;
  private int paytype;// '0支付宝 1银联 2 微信',
            private Date createTime;
            private Date payTime;
    private int paystatus;// '0未支付 1已支付 2 已退款',
            private String adress;
  private String telphone;
  private String username;
  private String tradenumber;
  private int number;
  private int orderstatus;// '0已提交 1已支付 2已取消 3已删除
            private Date updateTime;
            private long couponId;//'如果没有用优惠券的话 默认0
            private int couponAmount;//
  private long huodongId;//'如果没有用活动的话 默认0
            private long miaoshaId;//如果没有用秒杀的话 默认0
            private long tuangouId;//如果没有用团购的话 默认0

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getProductTypeId() {
        return productTypeId;
    }

    public void setProductTypeId(long productTypeId) {
        this.productTypeId = productTypeId;
    }

    public long getMerchartId() {
        return merchartId;
    }

    public void setMerchartId(long merchartId) {
        this.merchartId = merchartId;
    }

    public double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(double orderAmount) {
        this.orderAmount = orderAmount;
    }

    public double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(double payAmount) {
        this.payAmount = payAmount;
    }

    public int getPaytype() {
        return paytype;
    }

    public void setPaytype(int paytype) {
        this.paytype = paytype;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public int getPaystatus() {
        return paystatus;
    }

    public void setPaystatus(int paystatus) {
        this.paystatus = paystatus;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTradenumber() {
        return tradenumber;
    }

    public void setTradenumber(String tradenumber) {
        this.tradenumber = tradenumber;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(int orderstatus) {
        this.orderstatus = orderstatus;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public int getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(int couponAmount) {
        this.couponAmount = couponAmount;
    }

    public long getHuodongId() {
        return huodongId;
    }

    public void setHuodongId(long huodongId) {
        this.huodongId = huodongId;
    }

    public long getMiaoshaId() {
        return miaoshaId;
    }

    public void setMiaoshaId(long miaoshaId) {
        this.miaoshaId = miaoshaId;
    }

    public long getTuangouId() {
        return tuangouId;
    }

    public void setTuangouId(long tuangouId) {
        this.tuangouId = tuangouId;
    }
}
