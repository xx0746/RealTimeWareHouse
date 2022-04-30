package com.youfan.utils;

import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.PcProductCartLog;
import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

public class ObjectToMapUtils {

//    public static Map transferToMap(Object object){
//        Field[] fields = object.getClass().getDeclaredFields();
//        Map<String,String> dateMap = new HashMap<String,String>();
//        for(Field field:fields){
//            if(field.getType().getName().equals("java.util.Date")){
//                String filedName = field.getName();
//                System.out.println("日期字段"+filedName);
//                try {
//                    Method method = object.getClass().getMethod("get"+captureName(filedName));
//                    Object value = method.invoke(object);
//                    Date va = (Date) value;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                dateList.add(filedName);
//            }
//        }
//        String objectString = JSONObject.toJSONString(object);
//        Map map = JSONObject.parseObject(objectString,Map.class);
//        for(String dateF : dateList){
//            Object v = map.get(dateF);
//            String dateTime = DateUtils.transferDate(Long.valueOf(v+""),"yyyyMMdd");
//            map.put(dateF,dateTime);
//        }
//        return map;
//    }

    public static Map transferToMap(Object object){
        Field[] fields = object.getClass().getDeclaredFields();
       List<String> dateList = new ArrayList<>();
        for(Field field:fields){
            if(field.getType().getName().equals("java.util.Date")){
                String filedName = field.getName();
                dateList.add(filedName);
            }
        }
        String objectString = JSONObject.toJSONString(object);
        Map map = JSONObject.parseObject(objectString,Map.class);
        for(String dateF : dateList){
            Object v = map.get(dateF);
            if(v == null){
                continue;
            }
            String dateTime = DateUtils.transferDate(Long.valueOf(v+""),"yyyyMMdd");
            map.put(dateF,dateTime);
        }
        return map;
    }

    public static String captureName(String name) {
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        return name;
    }

    public static void main(String[] args) {
        PcProductCartLog pcProductCartLog = new PcProductCartLog();
        pcProductCartLog.setPindaoId("20");
        pcProductCartLog.setProductTypeId("20");
        pcProductCartLog.setProductId("20");
        pcProductCartLog.setCity("北京");
        Map map = transferToMap(pcProductCartLog);
        System.out.println("呵呵");

        ProductCartStatitisDay productCartStatitisDay = new ProductCartStatitisDay();
        productCartStatitisDay.setOperatorTimes(1);
        productCartStatitisDay.setOperatorTimedate(new Date());
        Map map2 = transferToMap(productCartStatitisDay);
        System.out.println("哈哈");

    }
}
