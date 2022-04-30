package com.youfan.map.dws;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.product.dwm.ProductInfoDwm;
import com.youfan.product.dws.ProductThemeDws;
import com.youfan.utils.DateUtils;
import com.youfan.utils.HbaesUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class ProducttinfothemeDayMap implements MapFunction<String, ProductThemeDws> {

    @Override
    public ProductThemeDws map(String s) throws Exception {
        ProductInfoDwm productInfoDwm = JSONObject.parseObject(s,ProductInfoDwm.class);
        long productTypeid = productInfoDwm.getProductTypeid();
        long shopId = productInfoDwm.getShopid();
        long merchantId = productInfoDwm.getMerchatid();
        long nubmers = productInfoDwm.getNumbers();
        long tradeNumbers = productInfoDwm.getTradenumbes();
        Date dateTime = productInfoDwm.getDateTime();
        String dateTimeString = productInfoDwm.getDateTimeString();


        ProductThemeDws productThemeDws = new ProductThemeDws();
        String shopIddre = HbaesUtils.getData("Producttinfotheme",dateTimeString+"=="+productTypeid,"info","shopnubmers"+shopId);
        if(StringUtils.isBlank(shopIddre)){
            productThemeDws.setShopnubmers(1l);
            HbaesUtils.putData("Producttinfotheme",dateTimeString+"=="+productTypeid,"info","shopnubmers"+shopId,"true");
        }

        String merchatnumbersdre = HbaesUtils.getData("Producttinfotheme",dateTimeString+"=="+productTypeid,"info","merchatnumbers"+merchantId);
        if(StringUtils.isBlank(merchatnumbersdre)){
            productThemeDws.setMerchatnumbers(1l);
            HbaesUtils.putData("Producttinfotheme",dateTimeString+"=="+productTypeid,"info","merchatnumbers"+merchantId,"true");
        }
        productThemeDws.setDateTime(dateTime);
        productThemeDws.setDateTimeString(dateTimeString);
        productThemeDws.setProductTypeid(productTypeid);
        productThemeDws.setNumbers(nubmers);
        productThemeDws.setTradenumbes(tradeNumbers);
        String groupField = "ProducttinfothemeThem=="+productTypeid+"=="+dateTimeString;
        productThemeDws.setGroupField(groupField);
        return productThemeDws;
    }
}
