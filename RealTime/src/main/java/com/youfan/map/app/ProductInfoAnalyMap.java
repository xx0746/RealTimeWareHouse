package com.youfan.map.app;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.product.app.ProductinfoApp;
import com.youfan.product.dws.MerchatnubmerThemeDws;
import com.youfan.product.dws.ProductThemeDws;
import com.youfan.trade.order.app.TradeApp;
import com.youfan.trade.order.dws.TradeProductthemeDay;
import com.youfan.trade.order.dws.TradeUserthemeDay;
import com.youfan.utils.DateUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class ProductInfoAnalyMap implements MapFunction<String, ProductinfoApp> {
    @Override
    public ProductinfoApp map(String s) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(s);
        String themeType = jsonObject.getString("themeType");
        ProductinfoApp productinfoApp = new ProductinfoApp();
        if("MERCHANT".equals(themeType)){//商家主题
            MerchatnubmerThemeDws  merchatnubmerThemeDws = JSONObject.parseObject(s, MerchatnubmerThemeDws.class);
            long shopnumbers = merchatnubmerThemeDws.getShopnubmers();
            Date dateTime =  merchatnubmerThemeDws.getDateTime();
            String dateTimeString = DateUtils.transferDate(dateTime,"yyyyMMdd");
            productinfoApp.setMerchantnumbers(1l);
            productinfoApp.setMerchantshopnubmers(shopnumbers);
            productinfoApp.setDateTime(dateTime);
            productinfoApp.setDateTimeString(dateTimeString);

        }else if("PRODUCT".equals(themeType)){//PRODUCT,//商品主题
            ProductThemeDws  productThemeDws = JSONObject.parseObject(s, ProductThemeDws.class);
            long numbers = productThemeDws.getNumbers();
            long tradenubmers = productThemeDws.getTradenumbes();
            Date dateTime =  productThemeDws.getDateTime();
            String dateTimeString = DateUtils.transferDate(dateTime,"yyyyMMdd");
            productinfoApp.setProductnumbers(numbers);
            productinfoApp.setProducttradenumbes(tradenubmers);
            productinfoApp.setDateTime(dateTime);
            productinfoApp.setDateTimeString(dateTimeString);
        }
        return  productinfoApp;
    }
}
