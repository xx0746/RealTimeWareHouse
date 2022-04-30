package com.youfan.service;

import com.alibaba.fastjson.JSONObject;
import com.youfan.product.ods.ProductInfo;
import com.youfan.result.DaPingResult;
import com.youfan.result.TradeResult;
import com.youfan.trade.order.ods.YoufanOrder;
import com.youfan.utils.DateUtils;
import com.youfan.utils.DorisDbUtils;
import com.youfan.utils.HbaesUtils;
import com.youfan.utils.RedisUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.*;

@Service
public class DaPingService {

    public DaPingResult productTypeTrade(){

        try{
            List<Map<String, Object>> ydata = new ArrayList<Map<String, Object>>();
            String sql = "select productTypeId,dateTimeString,sum(totalAmount) as totalAmountsum  from TradeApp group by dateTimeString,productTypeId  ";

            Map<String, Map<String, Long>> dataMap = new HashMap<String, Map<String, Long>>();
            ResultSet resultSet = DorisDbUtils.queryBySql( sql);
            Set<String> dateSet = new HashSet<String>();
            while (resultSet.next()) {
                String dateTimeString = resultSet.getString("dateTimeString");
                String productTypeId = resultSet.getString("productTypeId");
                String producttypeName = HbaesUtils.getData("productTypeInfo",productTypeId,"info","producttypeName");
                dateSet.add(dateTimeString);
                long numbers = resultSet.getLong("totalAmountsum");

                Map<String, Long> innerMap = dataMap.get(producttypeName);
                if (innerMap == null) {
                    innerMap = new HashMap<String, Long>();
                }
                long preData = innerMap.get(dateTimeString) == null ? 0l : innerMap.get(dateTimeString);
                numbers += preData;
                innerMap.put(dateTimeString, numbers);
                dataMap.put(producttypeName , innerMap);
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
                maptemp.put("type", "line");
                maptemp.put("stack", "总量");
                ydata.add(maptemp);
            }
            DaPingResult daPingResult = new DaPingResult();
            daPingResult.setyData(ydata);
            daPingResult.setxList(sortList);
            return daPingResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public DaPingResult realTimeTrade(){
        List<List<String>> datalistfinal = new ArrayList<List<String>>();
        Set<String> set = RedisUtils.getTopData("productinfotopicName",10);
        for(String youfanOrderSting:set){
            List<String> datalist = new ArrayList<String>();
            YoufanOrder youfanOrder = JSONObject.parseObject(youfanOrderSting, YoufanOrder.class);
            long productId = youfanOrder.getProductId();
            long productTyeId = youfanOrder.getProductTypeId();
            double amount = youfanOrder.getOrderAmount();
            try {
                String productName = HbaesUtils.getData("productInfo",productId+"","info","productName");
                datalist.add(productName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                String producttypeName = HbaesUtils.getData("productTypeInfo",productTyeId+"","info","producttypeName");
                datalist.add(producttypeName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            datalist.add("<span  class='colorGrass'>"+amount+"</span>");
            datalistfinal.add(datalist);
        }
        DaPingResult daPingResult = new DaPingResult();
        daPingResult.setTradeList(datalistfinal);
        daPingResult.setTradeListString(JSONObject.toJSONString(datalistfinal));

        return daPingResult;
    }
}
