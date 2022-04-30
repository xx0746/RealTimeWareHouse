package com.youfan.liuLiang.log;

import com.youfan.enums.LogType;
import com.youfan.enums.YeWuType;

public class LogParent {
    LogType logType;
    YeWuType yeWuType;
    private String deviceType;//设备类型，计算机、移动设备、其他等等

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public YeWuType getYeWuType() {
        return yeWuType;
    }

    public void setYeWuType(YeWuType yeWuType) {
        this.yeWuType = yeWuType;
    }
}
