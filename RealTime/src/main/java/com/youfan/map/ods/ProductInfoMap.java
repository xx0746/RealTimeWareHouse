package com.youfan.map.ods;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.AppProductCartLog;
import com.youfan.liuLiang.log.AppProductHuoDong;
import com.youfan.liuLiang.log.AppProductLog;
import com.youfan.liuLiang.log.LogParent;
import com.youfan.product.ods.ProductInfo;
import com.youfan.product.ods.ProductTypeInfo;
import com.youfan.utils.HbaesUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Map;

public class ProductInfoMap implements MapFunction<String,String> {

    @Override
    public String map(String s) throws Exception {
        ProductInfo productInfo = JSONObject.parseObject(s, ProductInfo.class);
        Map<String,String> map = ObjectToMapUtils.transferToMap(productInfo);
        if(productInfo.getId()<0){
            return null;
        }
        HbaesUtils.put("productInfo",productInfo.getId()+"","info",map);
        KafkaUtils.sendData("productdwd",s);
        return null;
    }

}
