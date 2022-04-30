package com.youfan.map.ods;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.AppProductCartLog;
import com.youfan.liuLiang.log.AppProductHuoDong;
import com.youfan.liuLiang.log.AppProductLog;
import com.youfan.liuLiang.log.LogParent;
import com.youfan.product.ods.MerchantInfo;
import com.youfan.utils.HbaesUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Map;

public class MerchantMap implements MapFunction<String,String> {

    @Override
    public String map(String s) throws Exception {
        MerchantInfo merchantInfo = JSONObject.parseObject(s, MerchantInfo.class);
        Map<String,String> map = ObjectToMapUtils.transferToMap(merchantInfo);
        if(merchantInfo.getId()<0){
            return null;
        }
        HbaesUtils.put("merchantinfo",merchantInfo.getId()+"","info",map);
        KafkaUtils.sendData("merchantdwd",s);
        return null;
    }

}
