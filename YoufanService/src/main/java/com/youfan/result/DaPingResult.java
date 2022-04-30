package com.youfan.result;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DaPingResult {
    private List<String> xList = new ArrayList<String>();
    private List<Map<String,Object>> yData = new ArrayList<Map<String,Object>>();

    private List<List<String>> tradeList = new ArrayList<>();
    private String tradeListString = "";

    public String getTradeListString() {
        return tradeListString;
    }

    public void setTradeListString(String tradeListString) {
        this.tradeListString = tradeListString;
    }

    public List<List<String>> getTradeList() {
        return tradeList;
    }

    public void setTradeList(List<List<String>> tradeList) {
        this.tradeList = tradeList;
    }

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
