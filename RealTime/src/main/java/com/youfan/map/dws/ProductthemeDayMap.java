package com.youfan.map.dws;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.utils.DateUtils;
import com.youfan.utils.HbaesUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Date;

public class ProductthemeDayMap implements MapFunction<String, ProductthemeDay> {
    @Override
    public ProductthemeDay map(String s) throws Exception {
        JSONObject jsonObject = JSONObject.parseObject(s);
        String yeWuType = jsonObject.getString("yeWuType");

        if(yeWuType.equals("PRODUCTHUODONG")){//活动
            return null;

        }
        String productId = jsonObject.getString("productId");
        String deviceType = jsonObject.getString("deviceType");
        Date timedate = null;
        String timedateString = null;
        ProductthemeDay productthemeDay = new ProductthemeDay();
        String groupField = "producttheme=="+productId+"=="+deviceType;
        if(yeWuType.equals("PRODUCTCART")){//购物车
            ProductCartStatitisDay productCartStatitisDay = JSONObject.parseObject(s,ProductCartStatitisDay.class);
            timedate = productCartStatitisDay.getOperatorTimedate();
            timedateString = DateUtils.transferDate(productCartStatitisDay.getOperatorTimedate(),"yyyyMMdd");
            String operatorType = productCartStatitisDay.getOperatorType();////0添加1删除
            long operatorTimes = productCartStatitisDay.getOperatorTimes();
            productthemeDay.setOperatorType(operatorType);
            productthemeDay.setOperatornums(operatorTimes);
            groupField += "=="+ operatorType;
        }else if (yeWuType.equals("PRODUCT")){//商品
            ProductStatitisDay productStatitisDay = JSONObject.parseObject(s, ProductStatitisDay.class);
            timedate = productStatitisDay.getScanTime();
            timedateString = DateUtils.transferDate(productStatitisDay.getScanTime(),"yyyyMMdd");
            long scanTimeTotal =  productStatitisDay.getScanTimetotals();
            long scantimes = productStatitisDay.getScantimes();
            String userId = productStatitisDay.getUserId();
            productthemeDay.setScanproducttotal(scantimes);
            productthemeDay.setScanproducttotaltime(scanTimeTotal);

            String userIdRe = HbaesUtils.getData("productinfoliuliang",timedateString+"=="+productId,"info","userId"+userId);
            if(StringUtils.isBlank(userIdRe)){
                productthemeDay.setUsernums(1l);
                HbaesUtils.putData("productinfoliuliang",timedateString+"=="+productId,"info","userId"+userId,"true");
            }
        }

        String diveType = HbaesUtils.getData("productdeviceinfo",timedateString+"=="+productId,"info","deviceType"+deviceType);
        if(StringUtils.isBlank(diveType)){
            productthemeDay.setDevicenums(1);
            HbaesUtils.putData("productdeviceinfo",timedateString+"=="+productId,"info","deviceType"+deviceType,"true");
        }
        groupField += "=="+ timedateString;
        productthemeDay.setProductId(productId);
        productthemeDay.setDateTime(timedate);
        productthemeDay.setDeviceType(deviceType);
        productthemeDay.setGroupField(groupField);
        return productthemeDay;
    }
}
