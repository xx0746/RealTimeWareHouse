package com.youfan.map.dws;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.trade.order.dwm.YouFanOrderDwmDay;
import com.youfan.trade.order.dws.TradeProductthemeDay;
import com.youfan.trade.order.dws.TradeUserthemeDay;
import com.youfan.utils.DateUtils;
import com.youfan.utils.HbaesUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class TradeProductthemeDayMap implements MapFunction<String, TradeProductthemeDay> {
    @Override
    public TradeProductthemeDay map(String s) throws Exception {
        YouFanOrderDwmDay youFanOrderDwmDay = JSONObject.parseObject(s, YouFanOrderDwmDay.class);
        long userId = youFanOrderDwmDay.getUserId();
        long productId = youFanOrderDwmDay.getProductId();
        long shopId = youFanOrderDwmDay.getShopId();
        long merchartId = youFanOrderDwmDay.getMerchartId();
        Date dateTime = youFanOrderDwmDay.getTimeDate();

        String timeDateString = DateUtils.transferDate(dateTime,"yyyyMMdd");
        int orderStatus = youFanOrderDwmDay.getOrderstatus();
        long numberstemp = youFanOrderDwmDay.getNumbers();
        TradeProductthemeDay tradeProductthemeDay = new TradeProductthemeDay();

        tradeProductthemeDay.setProductId(productId);
        tradeProductthemeDay.setDateTime(dateTime);
        tradeProductthemeDay.setStatus(orderStatus);

        String usernumsdre = HbaesUtils.getData("TradeProductthemeinfo",timeDateString+"=="+productId,"info","usernums"+userId);
        if(StringUtils.isBlank(usernumsdre)){
            tradeProductthemeDay.setUsernums(1l);
            HbaesUtils.putData("TradeProductthemeinfo",timeDateString+"=="+productId,"info","usernums"+userId,"true");
        }
        String shopIddre = HbaesUtils.getData("TradeProductthemeinfo",timeDateString+"=="+productId,"info","shopnumbers"+shopId);
        if(StringUtils.isBlank(shopIddre)){
            tradeProductthemeDay.setShopnumbers(1l);
            HbaesUtils.putData("TradeProductthemeinfo",timeDateString+"=="+productId,"info","shopnumbers"+shopId,"true");
        }

        String merchartdre = HbaesUtils.getData("TradeProductthemeinfo",timeDateString+"=="+productId,"info","merchartnumbers"+merchartId);
        if(StringUtils.isBlank(merchartdre)){
            tradeProductthemeDay.setMerchartnumbers(1l);
            HbaesUtils.putData("TradeProductthemeinfo",timeDateString+"=="+productId,"info","merchartnumbers"+merchartId,"true");
        }

        long  numbers = numberstemp;

        tradeProductthemeDay.setNumbers(numbers);
        long productTypId = youFanOrderDwmDay.getProducttypeId();
        String groupField = "TradeProducttheme=="+productId+"=="+timeDateString+"=="+orderStatus+"=="+productTypId;
        tradeProductthemeDay.setGroupField(groupField);

        return tradeProductthemeDay;
    }
}
