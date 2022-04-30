package com.youfan.map.dws;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import com.youfan.liuLiang.log.dwm.ProducthuodongStatitisDay;
import com.youfan.liuLiang.log.dws.UserthemeDay;
import com.youfan.trade.order.dwm.YouFanOrderDwmDay;
import com.youfan.trade.order.dws.TradeUserthemeDay;
import com.youfan.utils.DateUtils;
import com.youfan.utils.HbaesUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class TradeUserthemeDayMap implements MapFunction<String, TradeUserthemeDay> {
    @Override
    public TradeUserthemeDay map(String s) throws Exception {
        YouFanOrderDwmDay  youFanOrderDwmDay = JSONObject.parseObject(s, YouFanOrderDwmDay.class);
        long userId = youFanOrderDwmDay.getUserId();
        long productId = youFanOrderDwmDay.getProductId();
        long shopId = youFanOrderDwmDay.getShopId();
        long merchartId = youFanOrderDwmDay.getMerchartId();
        double orderAmountTotal = youFanOrderDwmDay.getOrderAmountTotal();
        Date dateTime = youFanOrderDwmDay.getTimeDate();
        String timeDateString = DateUtils.transferDate(dateTime,"yyyyMMdd");
        int orderStatus = youFanOrderDwmDay.getOrderstatus();
        long numberstemp = youFanOrderDwmDay.getNumbers();
        TradeUserthemeDay tradeUserthemeDay = new TradeUserthemeDay();
        tradeUserthemeDay.setUserId(userId);
        tradeUserthemeDay.setDateTime(dateTime);
        tradeUserthemeDay.setStatus(orderStatus);
        tradeUserthemeDay.setTotalAmount(orderAmountTotal);
        String productIddre = HbaesUtils.getData("TradeUserthemeinfo",timeDateString+"=="+userId,"info","productnums"+productId);
        if(StringUtils.isBlank(productIddre)){
            tradeUserthemeDay.setProductnums(1l);
            HbaesUtils.putData("TradeUserthemeinfo",timeDateString+"=="+userId,"info","productnums"+productId,"true");
        }

        String shopIddre = HbaesUtils.getData("TradeUserthemeinfo",timeDateString+"=="+userId,"info","shopnumbers"+shopId);
        if(StringUtils.isBlank(shopIddre)){
            tradeUserthemeDay.setShopnumbers(1l);
            HbaesUtils.putData("TradeUserthemeinfo",timeDateString+"=="+userId,"info","shopnumbers"+shopId,"true");
        }

        String merchartdre = HbaesUtils.getData("TradeUserthemeinfo",timeDateString+"=="+userId,"info","merchartnumbers"+merchartId);
        if(StringUtils.isBlank(merchartdre)){
            tradeUserthemeDay.setMerchartnumbers(1l);
            HbaesUtils.putData("TradeUserthemeinfo",timeDateString+"=="+userId,"info","merchartnumbers"+merchartId,"true");
        }
        long  numbers  = numberstemp;
        tradeUserthemeDay.setNumbers(numbers);
        long productTypeId = youFanOrderDwmDay.getProducttypeId();
        String groupField = "TradeUsertheme=="+userId+"=="+timeDateString+"=="+orderStatus+"=="+productTypeId;
        tradeUserthemeDay.setGroupField(groupField);
        tradeUserthemeDay.setProductTypeId(productTypeId);
        return tradeUserthemeDay;
    }
}
