package com.youfan.map.dws;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.product.dwm.ProductInfoDwm;
import com.youfan.product.dws.MerchatnubmerThemeDws;
import com.youfan.product.dws.ProductThemeDws;
import com.youfan.utils.DateUtils;
import com.youfan.utils.HbaesUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class MerchantinfothemeDayMap implements MapFunction<String, MerchatnubmerThemeDws> {

    @Override
    public MerchatnubmerThemeDws map(String s) throws Exception {
        ProductInfoDwm productInfoDwm = JSONObject.parseObject(s,ProductInfoDwm.class);
        long shopId = productInfoDwm.getShopid();
        long merchantId = productInfoDwm.getMerchatid();
        long nubmers = productInfoDwm.getNumbers();
        long tradeNumbers = productInfoDwm.getTradenumbes();
        Date dateTime = productInfoDwm.getDateTime();
        String dateTimeString = productInfoDwm.getDateTimeString();


        MerchatnubmerThemeDws  merchatnubmerThemeDws = new  MerchatnubmerThemeDws();
        String shopIddre = HbaesUtils.getData("MerchatnubmerTheme",dateTimeString+"=="+merchantId,"info","shopnubmers"+shopId);
        if(StringUtils.isBlank(shopIddre)){
            merchatnubmerThemeDws.setShopnubmers(1l);
            HbaesUtils.putData("MerchatnubmerTheme",dateTimeString+"=="+merchantId,"info","shopnubmers"+shopId,"true");
        }

        merchatnubmerThemeDws.setDateTime(dateTime);
        merchatnubmerThemeDws.setDateTimeString(dateTimeString);
        merchatnubmerThemeDws.setNumbers(nubmers);
        merchatnubmerThemeDws.setTradenumbes(tradeNumbers);
        String groupField = "MerchatnubmerThem=="+merchantId+"=="+dateTimeString;
        merchatnubmerThemeDws.setGroupField(groupField);

        return merchatnubmerThemeDws;
    }
}
