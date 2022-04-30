package com.youfan.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TubiaoEntity {
    private List<String> xList = new ArrayList<String>();
    private List<Map<String,Object>> yData = new ArrayList<Map<String,Object>>();

    public List<String> getxList() {
        return xList;
    }

    public void setxList(List<String> xList) {
        this.xList = xList;
    }

    public List<Map<String, Object>> getyData() {
        return yData;
    }

    public void setyData(List<Map<String, Object>> yData) {
        this.yData = yData;
    }
}
