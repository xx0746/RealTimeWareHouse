package com.youfan.map.ods;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.LogParent;
import com.youfan.liuLiang.log.PcProductCartLog;
import com.youfan.liuLiang.log.PcProductHuoDong;
import com.youfan.liuLiang.log.PcProductLog;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Map;

public class PcOdsMap implements MapFunction<String,String> {

    @Override
    public String map(String s) throws Exception {
        LogParent logParent = JSONObject.parseObject(s, LogParent.class);
        YeWuType yeWuType = logParent.getYeWuType();
        switch(yeWuType){
            case PRODUCTCART :
                PcProductCartLog pcProductCartLog = JSONObject.parseObject(s, PcProductCartLog.class);
                Map data = ObjectToMapUtils.transferToMap(pcProductCartLog);
//                DorisDbUtils.insertdata("PcProductCartLog",data);
                KafkaUtils.sendData("productcartdwd",s);
                break;
            case PRODUCTHUODONG:
                PcProductHuoDong pcProductHuoDong = JSONObject.parseObject(s, PcProductHuoDong.class);
                Map data2 = ObjectToMapUtils.transferToMap(pcProductHuoDong);
//                DorisDbUtils.insertdata("PcProductHuoDong",data2);
                KafkaUtils.sendData("productHuoDongdwd",s);
                break;
            case PRODUCT:
                PcProductLog pcProductLog= JSONObject.parseObject(s,PcProductLog.class);
                Map data3 = ObjectToMapUtils.transferToMap(pcProductLog);
//                DorisDbUtils.insertdata("PcProductLog",data3);
                KafkaUtils.sendData("productdwd",s);
                break;
        }
        return null;
    }

}
