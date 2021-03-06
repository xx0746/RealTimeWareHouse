package com.youfan.liuLiang.log;

public class XiaoChenXuDeviceLog extends LogParent{
    private String userId;//用户id
    private String deviceId = "";//设备id
    private String weixinAccount = "";//微信号
    private String weixinName = ""; //微信昵称
    private String weixinSex = "";//微信性别信息
    private String weixinArea = "";//微信地区
    private String openTime;//打开小程序时间
    private String leaveTime;//退出时间

    private String ip;//用户小程序访问的ip
    private String country;//国家
    private String province;//省
    private String city;//市

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getWeixinAccount() {
        return weixinAccount;
    }

    public void setWeixinAccount(String weixinAccount) {
        this.weixinAccount = weixinAccount;
    }

    public String getWeixinName() {
        return weixinName;
    }

    public void setWeixinName(String weixinName) {
        this.weixinName = weixinName;
    }

    public String getWeixinSex() {
        return weixinSex;
    }

    public void setWeixinSex(String weixinSex) {
        this.weixinSex = weixinSex;
    }

    public String getWeixinArea() {
        return weixinArea;
    }

    public void setWeixinArea(String weixinArea) {
        this.weixinArea = weixinArea;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
