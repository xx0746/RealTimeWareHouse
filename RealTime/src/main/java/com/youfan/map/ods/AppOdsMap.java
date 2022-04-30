package com.youfan.map.ods;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.AppProductCartLog;
import com.youfan.liuLiang.log.AppProductHuoDong;
import com.youfan.liuLiang.log.AppProductLog;
import com.youfan.liuLiang.log.LogParent;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Map;

public class AppOdsMap implements MapFunction<String,String> {

    @Override
    public String map(String s) throws Exception {
        LogParent logParent = JSONObject.parseObject(s, LogParent.class);
        YeWuType yeWuType = logParent.getYeWuType();
        switch(yeWuType){
            case PRODUCTCART :
                AppProductCartLog appProductCartLog = JSONObject.parseObject(s,AppProductCartLog.class);
                Map data = ObjectToMapUtils.transferToMap(appProductCartLog);
//                DorisDbUtils.insertdata("AppProductCartLog",data);
                KafkaUtils.sendData("productcartdwd",s);
                break;
            case PRODUCTHUODONG:
                AppProductHuoDong appProductHuoDong = JSONObject.parseObject(s, AppProductHuoDong.class);
                Map data2 = ObjectToMapUtils.transferToMap(appProductHuoDong);
//                DorisDbUtils.insertdata("AppProductHuoDong",data2);
                KafkaUtils.sendData("productHuoDongdwd",s);
                break;
            case PRODUCT:
                AppProductLog appProductLog= JSONObject.parseObject(s,AppProductLog.class);
                Map data3 = ObjectToMapUtils.transferToMap(appProductLog);
//                DorisDbUtils.insertdata("AppProductLog",data3);
                KafkaUtils.sendData("productdwd",s);
                break;
        }
        return null;
    }

}
