package com.youfan.map.dwd;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.LogType;
import com.youfan.liuLiang.log.*;
import com.youfan.liuLiang.log.dwd.ProductCartLog;
import com.youfan.liuLiang.log.dwd.ProductHuodongLog;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectCopyToUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Map;

public class ProductHuodongdwdMap implements MapFunction<String,String> {

    @Override
    public String map(String s) throws Exception {
        LogParent logParent = JSONObject.parseObject(s, LogParent.class);
        LogType logType = logParent.getLogType();
        switch(logType){
            case PC :
                PcProductHuoDong pcProductHuoDong = JSONObject.parseObject(s, PcProductHuoDong.class);
                ProductHuodongLog productHuodongLog = new ProductHuodongLog();
                ObjectCopyToUtils.copyto(productHuodongLog,pcProductHuoDong);
                Map data = ObjectToMapUtils.transferToMap(productHuodongLog);
//                DorisDbUtils.insertdata("ProductHuoDong",data);
                KafkaUtils.sendData("productHuoDongdwm",s);
                break;
            case XIAOCHENGXU:
                XiaoChenXuProductHuoDong  xiaoChenXuProductHuoDong = JSONObject.parseObject(s, XiaoChenXuProductHuoDong.class);

                ProductHuodongLog productHuodongLog2 = new ProductHuodongLog();
                ObjectCopyToUtils.copyto(productHuodongLog2,xiaoChenXuProductHuoDong);
                Map data2 = ObjectToMapUtils.transferToMap(productHuodongLog2);
//                DorisDbUtils.insertdata("ProductHuoDong",data2);
                KafkaUtils.sendData("productHuoDongdwm",s);
                break;
            case APP:
                AppProductHuoDong appProductHuoDong= JSONObject.parseObject(s,AppProductHuoDong.class);
                ProductHuodongLog productHuodongLog3 = new ProductHuodongLog();
                ObjectCopyToUtils.copyto(productHuodongLog3,appProductHuoDong);
                Map data3 = ObjectToMapUtils.transferToMap(productHuodongLog3);
//                DorisDbUtils.insertdata("ProductHuoDong",data3);
                KafkaUtils.sendData("productHuoDongdwm",s);
                break;
        }
        return null;
    }

}
