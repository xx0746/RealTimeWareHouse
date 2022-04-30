package com.youfan.map.app;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.app.Diveceanaly;
import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.liuLiang.log.dws.UserthemeDay;
import com.youfan.trade.order.app.TradeApp;
import com.youfan.trade.order.dws.TradeProductthemeDay;
import com.youfan.trade.order.dws.TradeUserthemeDay;
import com.youfan.utils.DateUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class TradeAnalyMap implements MapFunction<String, TradeApp> {
    @Override
    public TradeApp map(String s) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(s);
        String themeType = jsonObject.getString("themeType");
        TradeApp tradeApp = new TradeApp();
        if("USER".equals(themeType)){//USER,//用户主题
            TradeUserthemeDay userthemeDay = JSONObject.parseObject(s, TradeUserthemeDay.class);
            Date dateTime = userthemeDay.getDateTime();
            String dateTimeString = DateUtils.transferDate(dateTime,"yyyyMMdd");
            long ordernumbers = userthemeDay.getNumbers();
            double totalamount = userthemeDay.getTotalAmount();
            long productTypeId = userthemeDay.getProductTypeId();
            tradeApp.setOrdernumbers(ordernumbers);
            tradeApp.setUsernumser(1l);
            tradeApp.setTotalAmount(totalamount);
            tradeApp.setDateTimeString(dateTimeString);
            tradeApp.setProductTypeId(productTypeId);
            String gourpField = "TradeApp=="+productTypeId+"=="+dateTimeString;
            tradeApp.setGourpField(gourpField);
        }else if("PRODUCT".equals(themeType)){//PRODUCT,//商品主题
            TradeProductthemeDay tradeProductthemeDay = JSONObject.parseObject(s, TradeProductthemeDay.class);
            long productTypeId = tradeProductthemeDay.getProductTyId();
            Date dateTime = tradeProductthemeDay.getDateTime();
            String dateTimeString = DateUtils.transferDate(dateTime,"yyyyMMdd");
            tradeApp.setDateTime(dateTime);
            tradeApp.setProductnumser(1l);
            tradeApp.setDateTimeString(dateTimeString);
            tradeApp.setProductTypeId(productTypeId);
            String gourpField = "TradeApp=="+productTypeId+"=="+dateTimeString;
            tradeApp.setGourpField(gourpField);
        }
        return  tradeApp;
    }
}
