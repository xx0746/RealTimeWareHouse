package com.youfan.map.app;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.ThemeType;
import com.youfan.liuLiang.log.app.ProductCartanaly;
import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.liuLiang.log.dws.UserthemeDay;
import com.youfan.utils.DateUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class ProductCartanalyMap implements MapFunction<String, ProductCartanaly> {
    @Override
    public ProductCartanaly map(String s) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(s);
        String themeType = jsonObject.getString("themeType");
        ProductCartanaly productCartanaly = new ProductCartanaly();
    try {
        if ("USER".equals(themeType)) {//USER,//用户主题
            UserthemeDay userthemeDay = JSONObject.parseObject(s, UserthemeDay.class);
            long operatornumbers = userthemeDay.getOperatornumbers();
            String operatorType = userthemeDay.getOperatorType();
            Date dateTime = userthemeDay.getDateTime();
            String dateTimeString = DateUtils.transferDate(dateTime, "yyyyMMdd");
            productCartanaly.setOperatorType(operatorType);
            productCartanaly.setDateTime(dateTime);
            productCartanaly.setDateTimeString(dateTimeString);
            productCartanaly.setPv(operatornumbers);
            productCartanaly.setUv(1l);
            String groupField = "ProductCartanaly==" + operatorType + "==" + dateTimeString;
            productCartanaly.setGroupField(groupField);


        } else if ("PRODUCT".equals(themeType)) {//PRODUCT,//商品主题
            ProductthemeDay productthemeDay = JSONObject.parseObject(s, ProductthemeDay.class);
            String operatorType = productthemeDay.getOperatorType();
            Date dateTime = productthemeDay.getDateTime();
            String dateTimeString = DateUtils.transferDate(dateTime, "yyyyMMdd");
            productCartanaly.setOperatorType(operatorType);
            productCartanaly.setDateTime(dateTime);
            productCartanaly.setDateTimeString(dateTimeString);
            productCartanaly.setProductnums(1l);
            String groupField = "ProductCartanaly==" + operatorType + "==" + dateTimeString;
            productCartanaly.setGroupField(groupField);
        }

    }catch (Exception e){
        e.printStackTrace();
    }
        return productCartanaly;
    }
}
