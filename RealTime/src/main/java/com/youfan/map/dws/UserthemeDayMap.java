package com.youfan.map.dws;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import com.youfan.liuLiang.log.dwm.ProducthuodongStatitisDay;
import com.youfan.liuLiang.log.dws.UserthemeDay;
import com.youfan.utils.DateUtils;
import com.youfan.utils.HbaesUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class UserthemeDayMap implements MapFunction<String, UserthemeDay> {
    @Override
    public UserthemeDay map(String s) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(s);
        String yeWuType = jsonObject.getString("yeWuType");
        String userId = jsonObject.getString("userId");
        String deviceType = jsonObject.getString("deviceType");
        Date timedate = null;
        String timedateString = null;
        UserthemeDay userthemeDay = new UserthemeDay();
        if(yeWuType.equals("PRODUCTCART")){//购物车

            ProductCartStatitisDay productCartStatitisDay = JSONObject.parseObject(s,ProductCartStatitisDay.class);
            timedate = productCartStatitisDay.getOperatorTimedate();
            timedateString = DateUtils.transferDate(productCartStatitisDay.getOperatorTimedate(),"yyyyMMdd");
            String operatorType = productCartStatitisDay.getOperatorType();////0添加1删除
            long operatorTimes = productCartStatitisDay.getOperatorTimes();
            userthemeDay.setOperatorType(operatorType);
            userthemeDay.setOperatornumbers(operatorTimes);

        }else if(yeWuType.equals("PRODUCTHUODONG")){//活动
            ProducthuodongStatitisDay producthuodongStatitisDay = JSONObject.parseObject(s, ProducthuodongStatitisDay.class);
            timedate = producthuodongStatitisDay.getScanTime();
            timedateString = DateUtils.transferDate(producthuodongStatitisDay.getScanTime(),"yyyyMMdd");
            String huodongId = producthuodongStatitisDay.getHuodongId();

            String huodongIdre = HbaesUtils.getData("userproductinfo",timedateString+"=="+userId,"info","huodong"+huodongId);
            if(StringUtils.isBlank(huodongIdre)){
                userthemeDay.setScanhuodongnums(1l);
                HbaesUtils.putData("userproductinfo",timedateString+"=="+userId,"info","huodong"+huodongId,"true");
            }

        }else if (yeWuType.equals("PRODUCT")){//商品
            ProductStatitisDay productStatitisDay = JSONObject.parseObject(s, ProductStatitisDay.class);
            timedateString = DateUtils.transferDate(productStatitisDay.getScanTime(),"yyyyMMdd");
            timedate = productStatitisDay.getScanTime();
            String productId= productStatitisDay.getProductId();
            long scantimes = productStatitisDay.getScantimes();
            userthemeDay.setScanproducttotal(scantimes);
            String productIdre = HbaesUtils.getData("userproductinfo",timedateString+"=="+userId,"info","product"+productId);
            if(StringUtils.isBlank(productIdre)){
                userthemeDay.setScanproudctnums(1l);
                HbaesUtils.putData("userproductinfo",timedateString+"=="+userId,"info","product"+productId,"true");
            }
            String productTypeId  =  productStatitisDay.getProductTypeId();
            String productTypeIdre = HbaesUtils.getData("userproductinfo",timedateString+"=="+userId,"info","producttype"+productTypeId);
            if(StringUtils.isBlank(productTypeIdre)){
                userthemeDay.setScanproducttypenums(1l);
                HbaesUtils.putData("userproductinfo",timedateString+"=="+userId,"info","producttype"+productTypeId,"true");
            }
            String pingdaoId = productStatitisDay.getPindaoId();
            String pingdaoIdre = HbaesUtils.getData("userproductinfo",timedateString+"=="+userId,"info","pingdao"+pingdaoId);
            if(StringUtils.isBlank(pingdaoIdre)){
                userthemeDay.setScanpingdaonums(1l);
                HbaesUtils.putData("userproductinfo",timedateString+"=="+userId,"info","pingdao"+pingdaoId,"true");
            }
            userthemeDay.setDeviceTypenumbers(1l);
        }

        String diveType = HbaesUtils.getData("userdeviceinfo",timedateString+"=="+userId,"info","deviceType"+deviceType);
        if(StringUtils.isBlank(diveType)){
            userthemeDay.setDevicenums(1);
            HbaesUtils.putData("userdeviceinfo",timedateString+"=="+userId,"info","deviceType"+deviceType,"true");
        }

        userthemeDay.setUserId(userId);
        userthemeDay.setDateTime(timedate);
        userthemeDay.setDeviceType(deviceType);
        String groupField = "Usertheme=="+userId+"=="+timedate+"=="+deviceType;
        userthemeDay.setGroupField(groupField);

        return userthemeDay;
    }
}
