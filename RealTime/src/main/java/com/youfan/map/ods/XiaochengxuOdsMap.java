package com.youfan.map.ods;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.LogParent;
import com.youfan.liuLiang.log.XiaoChenXuProductCartLog;
import com.youfan.liuLiang.log.XiaoChenXuProductHuoDong;
import com.youfan.liuLiang.log.XiaoChenxuProductLog;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Map;

public class XiaochengxuOdsMap implements MapFunction<String,String> {

    @Override
    public String map(String s) throws Exception {
        LogParent logParent = JSONObject.parseObject(s, LogParent.class);
        YeWuType yeWuType = logParent.getYeWuType();
        switch(yeWuType){
            case PRODUCTCART :
                XiaoChenXuProductCartLog xiaoChenXuProductCartLog = JSONObject.parseObject(s, XiaoChenXuProductCartLog.class);
                Map data = ObjectToMapUtils.transferToMap(xiaoChenXuProductCartLog);
//                DorisDbUtils.insertdata("XiaoChenXuProductCartLog",data);
                KafkaUtils.sendData("productcartdwd",s);
                break;
            case PRODUCTHUODONG:
                XiaoChenXuProductHuoDong xiaoChenXuProductHuoDong = JSONObject.parseObject(s, XiaoChenXuProductHuoDong.class);
                Map data2 = ObjectToMapUtils.transferToMap(xiaoChenXuProductHuoDong);
//                DorisDbUtils.insertdata("XiaoChenXuProductHuoDong",data2);
                KafkaUtils.sendData("productHuoDongdwd",s);
                break;
            case PRODUCT:
                XiaoChenxuProductLog  xiaoChenxuProductLog= JSONObject.parseObject(s,XiaoChenxuProductLog.class);
                Map data3 = ObjectToMapUtils.transferToMap(xiaoChenxuProductLog);
//                DorisDbUtils.insertdata("XiaoChenxuProductLog",data3);
                KafkaUtils.sendData("productdwd",s);
                break;
        }
        return null;
    }

}
