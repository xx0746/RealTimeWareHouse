package com.youfan.liuLiang.log.dwd;

public class ProductHuodongLog {
    private String userId;
    private String deviceId;
    private String openTimeStamp;//打开时间
    private String leaveTimeStamp;//退出时间
    private String appPlatform;//平台，安卓，IOS
    private String deviceStyle;//型号
    private String brand;//品牌
    private String screenSize;//分辨率
    private String osType;//操作系统
    private String ip;//用户app访问的ip
    private String country;//国家
    private String province;//省
    private String city;//市
    private String network;//网络方式
    private String yunYinShang;//运营商
    private String appVersion;//app版本
    private String appChannel;//渠道


    private String macAdress = "";//mac地址
    private String cookie;//如果没有cookie，用户禁用了cookie，或者由于其他原因为获取到，该字段值为空
    private String remoteIP;//客户端的ip
    private String remoteName;//客户端名称
    private String deviceType;//设备类型，计算机、移动设备、其他等等
    private String os;//操作系统
    private String brower;//浏览器信息
    private String resolution;//分辨率
    private String sourceInfo;//搜索引擎
    private String sourceType;//跳转源类型
    private String srcDomain;//跳转来源地址

    private String weixinAccount = "";//微信号
    private String weixinName = ""; //微信昵称
    private String weixinSex = "";//微信性别信息
    private String weixinArea = "";//微信地区
    private String openTime;//打开小程序时间
    private String leaveTime;//退出时间

    private String huodongId;//活动id
    private String scantime;//浏览的时间
    private String jumpTime;//跳出活动的时间

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

    public String getOpenTimeStamp() {
        return openTimeStamp;
    }

    public void setOpenTimeStamp(String openTimeStamp) {
        this.openTimeStamp = openTimeStamp;
    }

    public String getLeaveTimeStamp() {
        return leaveTimeStamp;
    }

    public void setLeaveTimeStamp(String leaveTimeStamp) {
        this.leaveTimeStamp = leaveTimeStamp;
    }

    public String getAppPlatform() {
        return appPlatform;
    }

    public void setAppPlatform(String appPlatform) {
        this.appPlatform = appPlatform;
    }

    public String getDeviceStyle() {
        return deviceStyle;
    }

    public void setDeviceStyle(String deviceStyle) {
        this.deviceStyle = deviceStyle;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public String getOsType() {
        return osType;
    }

    public void setOsType(String osType) {
        this.osType = osType;
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

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getYunYinShang() {
        return yunYinShang;
    }

    public void setYunYinShang(String yunYinShang) {
        this.yunYinShang = yunYinShang;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getAppChannel() {
        return appChannel;
    }

    public void setAppChannel(String appChannel) {
        this.appChannel = appChannel;
    }

    public String getMacAdress() {
        return macAdress;
    }

    public void setMacAdress(String macAdress) {
        this.macAdress = macAdress;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public String getRemoteIP() {
        return remoteIP;
    }

    public void setRemoteIP(String remoteIP) {
        this.remoteIP = remoteIP;
    }

    public String getRemoteName() {
        return remoteName;
    }

    public void setRemoteName(String remoteName) {
        this.remoteName = remoteName;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getBrower() {
        return brower;
    }

    public void setBrower(String brower) {
        this.brower = brower;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSourceInfo() {
        return sourceInfo;
    }

    public void setSourceInfo(String sourceInfo) {
        this.sourceInfo = sourceInfo;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    public String getSrcDomain() {
        return srcDomain;
    }

    public void setSrcDomain(String srcDomain) {
        this.srcDomain = srcDomain;
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

    public String getHuodongId() {
        return huodongId;
    }

    public void setHuodongId(String huodongId) {
        this.huodongId = huodongId;
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
