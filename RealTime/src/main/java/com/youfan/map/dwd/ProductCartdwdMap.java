package com.youfan.map.dwd;

import com.alibaba.fastjson.JSONObject;
import com.youfan.enums.LogType;
import com.youfan.enums.YeWuType;
import com.youfan.liuLiang.log.*;
import com.youfan.liuLiang.log.dwd.ProductCartLog;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectCopyToUtils;
import com.youfan.utils.ObjectToMapUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Map;

public class ProductCartdwdMap implements MapFunction<String,String> {

    @Override
    public String map(String s) throws Exception {
        LogParent logParent = JSONObject.parseObject(s, LogParent.class);
        LogType logType = logParent.getLogType();
        switch(logType){
            case PC :
                PcProductCartLog pcProductCartLog = JSONObject.parseObject(s, PcProductCartLog.class);
                ProductCartLog productCartLog = new ProductCartLog();
                ObjectCopyToUtils.copyto(productCartLog,pcProductCartLog);
                Map data = ObjectToMapUtils.transferToMap(productCartLog);
//                DorisDbUtils.insertdata("ProductCartLog",data);
                KafkaUtils.sendData("productcartdwm",JSONObject.toJSONString(productCartLog));
                break;
            case XIAOCHENGXU:
                XiaoChenXuProductCartLog  xiaoChenxuProductLog = JSONObject.parseObject(s,  XiaoChenXuProductCartLog.class);

                ProductCartLog productCartLog2 = new ProductCartLog();
                ObjectCopyToUtils.copyto(productCartLog2,xiaoChenxuProductLog);
                Map data2 = ObjectToMapUtils.transferToMap(productCartLog2);
//                DorisDbUtils.insertdata("ProductCartLog",data2);
                KafkaUtils.sendData("productcartdwm",JSONObject.toJSONString(productCartLog2));
                break;
            case APP:
                AppProductCartLog appProductCartLog= JSONObject.parseObject(s,AppProductCartLog.class);

                ProductCartLog productCartLog3 = new ProductCartLog();
                ObjectCopyToUtils.copyto(productCartLog3,appProductCartLog);
                Map data3 = ObjectToMapUtils.transferToMap(productCartLog3);
//                DorisDbUtils.insertdata("ProductCartLog",data3);
                KafkaUtils.sendData("productcartdwm",JSONObject.toJSONString(productCartLog3));
                break;
        }
        return null;
    }

}
