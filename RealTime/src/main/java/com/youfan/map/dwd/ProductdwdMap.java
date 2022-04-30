package com.youfan.map.dwd;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.LogType;
import com.youfan.liuLiang.log.*;
import com.youfan.liuLiang.log.dwd.ProductCartLog;
import com.youfan.liuLiang.log.dwd.ProductLog;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectCopyToUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Map;

public class ProductdwdMap implements MapFunction<String,String> {

    @Override
    public String map(String s) throws Exception {
        LogParent logParent = JSONObject.parseObject(s, LogParent.class);
        LogType logType = logParent.getLogType();
        switch(logType){
            case PC :
                PcProductLog pcProductLog = JSONObject.parseObject(s, PcProductLog.class);
                ProductLog productLog = new ProductLog();
                ObjectCopyToUtils.copyto(productLog,pcProductLog);
                Map data = ObjectToMapUtils.transferToMap(productLog);
//                DorisDbUtils.insertdata("ProductLog",data);
                KafkaUtils.sendData("productdwm",s);
                break;
            case XIAOCHENGXU:
                XiaoChenxuProductLog  xiaoChenxuProductLog = JSONObject.parseObject(s, XiaoChenxuProductLog.class);
                ProductLog productLog2 = new ProductLog();
                ObjectCopyToUtils.copyto(productLog2,xiaoChenxuProductLog);
                Map data2 = ObjectToMapUtils.transferToMap(productLog2);
//                DorisDbUtils.insertdata("ProductLog",data2);
                KafkaUtils.sendData("productdwm",s);
                break;
            case APP:
                AppProductLog appProductLog= JSONObject.parseObject(s,AppProductLog.class);

                ProductLog productLog3 = new ProductLog();
                ObjectCopyToUtils.copyto(productLog3,appProductLog);
                Map data3 = ObjectToMapUtils.transferToMap(productLog3);
//                DorisDbUtils.insertdata("ProductLog",data3);
                KafkaUtils.sendData("productdwm",s);
                break;
        }
        return null;
    }

}
