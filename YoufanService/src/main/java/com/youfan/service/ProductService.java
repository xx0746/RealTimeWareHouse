package com.youfan.service;

import com.youfan.result.ProductResult;
import com.youfan.result.TradeResult;
import com.youfan.utils.DateUtils;
import com.youfan.utils.DorisDbUtils;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;

@Service
public class ProductService {

    public ProductResult product(String valueFlag){

        try{
            List<Map<String, Object>> ydata = new ArrayList<Map<String, Object>>();
            String sql = "select dateTimeString,sum(productnumbers) as productnumberssum, sum(producttradenumbes) as producttradenumbessum,sum(merchantnumbers) as merchantnumberssum,sum(merchantshopnubmers) as merchantshopnubmerssum  from ProductinfoApp group by dateTimeString  ";

            String fieldName = "productnumberssum";
            String mapname = "商品上架趋势";
            if(valueFlag.equals("producttradenumbes")){
                fieldName = "producttradenumbessum";
                mapname = "商品成交趋势";
            }else  if(valueFlag.equals("merchantnumbers")){
                fieldName = "merchantnumberssum";
                mapname = "商家数趋势";
            }else  if(valueFlag.equals("merchantshopnubmers")){
                fieldName = "merchantshopnubmerssum";
                mapname = "商家开店数趋势";
            }

            Map<String, Map<String, Long>> dataMap = new HashMap<String, Map<String, Long>>();
            ResultSet resultSet = DorisDbUtils.queryBySql( sql);
            Set<String> dateSet = new HashSet<String>();
            while (resultSet.next()) {
                String dateTimeString = resultSet.getString("dateTimeString");
                dateSet.add(dateTimeString);
                long numbers = resultSet.getLong(fieldName);

                Map<String, Long> innerMap = dataMap.get(mapname);
                if (innerMap == null) {
                    innerMap = new HashMap<String, Long>();
                }
                long preData = innerMap.get(dateTimeString) == null ? 0l : innerMap.get(dateTimeString);
                numbers += preData;
                innerMap.put(dateTimeString, numbers);
                dataMap.put(mapname , innerMap);
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
            ProductResult productResult = new ProductResult();
            productResult.setyData(ydata);
            productResult.setxList(sortList);
            return productResult;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
