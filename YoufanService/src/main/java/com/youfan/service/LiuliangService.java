package com.youfan.service;

import com.youfan.result.LiuliangResult;
import com.youfan.utils.DateUtils;
import com.youfan.utils.DorisDbUtils;
import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.ResultSet;
import java.util.*;

@Service
public class LiuliangService {
    private  static Map<Integer,String> operationMap = new HashMap<Integer, String>();
    static {
        operationMap.put(0,"添加操作");
        operationMap.put(1,"删除操作");
    }

    private  static Map<Integer,String> diveceMap = new HashMap<Integer, String>();
    static {
        diveceMap.put(1,"PC端");
        diveceMap.put(2,"App端");
        diveceMap.put(3,"小程序端");
    }

    public LiuliangResult productCart(String valueFlag){

        try{
        List<Map<String, Object>> ydata = new ArrayList<Map<String, Object>>();
        String sql = "select operatorType,dateTimeString,sum(pv) as pvsum, sum(uv) as uvsum,sum(productnums) as productnumssum  from ProductCartanaly group by operatorType,dateTimeString  ";

        String fieldName = "pvsum";
        if(valueFlag.equals("uv")){
            fieldName = "uvsum";
        }else  if(valueFlag.equals("productnums")){
            fieldName = "productnumssum";
        }

        Map<String, Map<String, Long>> dataMap = new HashMap<String, Map<String, Long>>();
        ResultSet resultSet = DorisDbUtils.queryBySql( sql);
        Set<String> dateSet = new HashSet<String>();
        while (resultSet.next()) {
            String dateTimeString = resultSet.getString("dateTimeString");
            dateSet.add(dateTimeString);
            int operatorType = resultSet.getInt("operatorType");
            String operatorTypeName = operationMap.get(operatorType);
            long numbers = resultSet.getLong(fieldName);

            Map<String, Long> innerMap = dataMap.get(operatorTypeName);
            if (innerMap == null) {
                innerMap = new HashMap<String, Long>();
            }
            long preData = innerMap.get(dateTimeString) == null ? 0l : innerMap.get(dateTimeString);
            numbers += preData;
            innerMap.put(dateTimeString, numbers);
            dataMap.put(operatorTypeName , innerMap);
        }

        List<String> sortList = new ArrayList<>(dateSet);
        Collections.sort(sortList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result = 0;
                result = DateUtils.compareDate(o1, o2, "yyyyMMdd");
                return result;
            }
        });
        Map<String, Long> dateMapTemp = new HashMap<String, Long>();
        for (String timeinfo : sortList) {
            dateMapTemp.put(timeinfo, 0l);
        }

        Set<Map.Entry<String, Map<String, Long>>> dataMapSet = dataMap.entrySet();
        for (Map.Entry<String, Map<String, Long>> entry : dataMapSet) {
            String name = entry.getKey();
            Map<String, Long> dateMap = entry.getValue();
            Set<Map.Entry<String, Long>> entrySetinner = dateMap.entrySet();
            Map<String, Long> deepCopy = new HashMap<String, Long>();
            deepCopy.putAll(dateMapTemp);
            for (Map.Entry<String, Long> entryinser : entrySetinner) {
                String key = entryinser.getKey();
                long value = entryinser.getValue();
                deepCopy.put(key, value);
            }
            List<Long> dataList = new ArrayList<>();
            for (String key : sortList) {
                Long val = deepCopy.get(key);
                dataList.add(val);
            }
            Map<String, Object> maptemp = new HashMap<>();
            maptemp.put("name", name);
            maptemp.put("data", dataList);
            ydata.add(maptemp);
        }
        LiuliangResult liuliangResult = new LiuliangResult();
        liuliangResult.setyData(ydata);
        liuliangResult.setxList(sortList);
        return liuliangResult;
    }catch (Exception e){
        e.printStackTrace();
    }
        return null;
    }


    public LiuliangResult device(String valueFlag){

        try{
            List<Map<String, Object>> ydata = new ArrayList<Map<String, Object>>();
            String sql = "select diveceType,dateTimeString,sum(pv) as pvsum, sum(uv) as uvsum,sum(productnums) as productnumssum  from Diveceanaly group by diveceType,dateTimeString  ";

            String fieldName = "pvsum";
            if(valueFlag.equals("uv")){
                fieldName = "uvsum";
            }else  if(valueFlag.equals("productnums")){
                fieldName = "productnumssum";
            }

            Map<String, Map<String, Long>> dataMap = new HashMap<String, Map<String, Long>>();
            ResultSet resultSet = DorisDbUtils.queryBySql( sql);
            Set<String> dateSet = new HashSet<String>();
            while (resultSet.next()) {
                String dateTimeString = resultSet.getString("dateTimeString");
                dateSet.add(dateTimeString);
                int diveceType = resultSet.getInt("diveceType");
                String operatorTypeName = diveceMap.get(diveceType);
                long numbers = resultSet.getLong(fieldName);

                Map<String, Long> innerMap = dataMap.get(operatorTypeName);
                if (innerMap == null) {
                    innerMap = new HashMap<String, Long>();
                }
                long preData = innerMap.get(dateTimeString) == null ? 0l : innerMap.get(dateTimeString);
                numbers += preData;
                innerMap.put(dateTimeString, numbers);
                dataMap.put(operatorTypeName , innerMap);
            }

            List<String> sortList = new ArrayList<>(dateSet);
            Collections.sort(sortList, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    int result = 0;
                    result = DateUtils.compareDate(o1, o2, "yyyyMMdd");
                    return result;
                }
            });
            Map<String, Long> dateMapTemp = new HashMap<String, Long>();
            for (String timeinfo : sortList) {
                dateMapTemp.put(timeinfo, 0l);
            }

            Set<Map.Entry<String, Map<String, Long>>> dataMapSet = dataMap.entrySet();
            for (Map.Entry<String, Map<String, Long>> entry : dataMapSet) {
                String name = entry.getKey();
                Map<String, Long> dateMap = entry.getValue();
                Set<Map.Entry<String, Long>> entrySetinner = dateMap.entrySet();
                Map<String, Long> deepCopy = new HashMap<String, Long>();
                deepCopy.putAll(dateMapTemp);
                for (Map.Entry<String, Long> entryinser : entrySetinner) {
                    String key = entryinser.getKey();
                    long value = entryinser.getValue();
                    deepCopy.put(key, value);
                }
                List<Long> dataList = new ArrayList<>();
                for (String key : sortList) {
                    Long val = deepCopy.get(key);
                    dataList.add(val);
                }
                Map<String, Object> maptemp = new HashMap<>();
                maptemp.put("name", name);
                maptemp.put("data", dataList);
                ydata.add(maptemp);
            }
            LiuliangResult liuliangResult = new LiuliangResult();
            liuliangResult.setyData(ydata);
            liuliangResult.setxList(sortList);
            return liuliangResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
