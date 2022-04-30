package com.youfan.control;

import com.youfan.result.LiuliangResult;
import com.youfan.result.TradeResult;
import com.youfan.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class TradeControl {

    @Autowired
    private TradeService tradeService;


    @RequestMapping(value = "ordernumsQushi",method = RequestMethod.POST)
    public TradeResult ordernumsQushi(){
        return tradeService.trade("ordernumbers");

//        List<String> xlist = new ArrayList<String>();
//        xlist.add("20200905");
//        xlist.add("20200906");
//        xlist.add("20200907");
//        xlist.add("20200908");
//        xlist.add("20200909");
//        xlist.add("20200910");
//
//        List<Map<String,Object>> ydata = new ArrayList<Map<String,Object>>();
//        List<Long> datalist = new ArrayList<Long>();
//        datalist.add(45l);
//        datalist.add(556l);
//        datalist.add(25l);
//        datalist.add(65l);
//        datalist.add(16l);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","订单趋势");
//        map.put("data",datalist);
//        ydata.add(map);
//
//
//
//        TradeResult tradeResult = new TradeResult();
//        tradeResult.setxList(xlist);
//        tradeResult.setyData(ydata);
//
//        return tradeResult;
    }

    @RequestMapping(value = "orderusernumsQushi",method = RequestMethod.POST)
    public TradeResult orderusernumsQushi(){
        return tradeService.trade("usernumsers");

//        List<String> xlist = new ArrayList<String>();
//        xlist.add("20200905");
//        xlist.add("20200906");
//        xlist.add("20200907");
//        xlist.add("20200908");
//        xlist.add("20200909");
//        xlist.add("20200910");
//
//        List<Map<String,Object>> ydata = new ArrayList<Map<String,Object>>();
//        List<Long> datalist = new ArrayList<Long>();
//        datalist.add(45l);
//        datalist.add(561l);
//        datalist.add(25l);
//        datalist.add(357l);
//        datalist.add(16l);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","用户趋势");
//        map.put("data",datalist);
//        ydata.add(map);
//
//
//
//        TradeResult tradeResult = new TradeResult();
//        tradeResult.setxList(xlist);
//        tradeResult.setyData(ydata);
//
//        return tradeResult;
    }

    @RequestMapping(value = "dapanbaobiao",method = RequestMethod.POST)
    public TradeResult dapanbaobiao(){
        return tradeService.trade("totalAmount");

//        List<String> xlist = new ArrayList<String>();
//        xlist.add("20200905");
//        xlist.add("20200906");
//        xlist.add("20200907");
//        xlist.add("20200908");
//        xlist.add("20200909");
//        xlist.add("20200910");
//
//        List<Map<String,Object>> ydata = new ArrayList<Map<String,Object>>();
//        List<Double> datalist = new ArrayList<Double>();
//        datalist.add(456.67d);
//        datalist.add(565d);
//        datalist.add(25d);
//        datalist.add(357d);
//        datalist.add(16d);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","总金额");
//        map.put("data",datalist);
//        ydata.add(map);
//
//
//
//        TradeResult tradeResult = new TradeResult();
//        tradeResult.setxList(xlist);
//        tradeResult.setyData(ydata);
//
//        return tradeResult;
    }

    @RequestMapping(value = "orderproductnumsQushi",method = RequestMethod.POST)
    public TradeResult orderproductnumsQushi(){
        return tradeService.trade("productnumser");

//        List<String> xlist = new ArrayList<String>();
//        xlist.add("20200905");
//        xlist.add("20200906");
//        xlist.add("20200907");
//        xlist.add("20200908");
//        xlist.add("20200909");
//        xlist.add("20200910");
//
//        List<Map<String,Object>> ydata = new ArrayList<Map<String,Object>>();
//        List<Long> datalist = new ArrayList<Long>();
//        datalist.add(45l);
//        datalist.add(5612l);
//        datalist.add(252l);
//        datalist.add(357l);
//        datalist.add(16l);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","商品趋势");
//        map.put("data",datalist);
//        ydata.add(map);
//
//
//
//        TradeResult tradeResult = new TradeResult();
//        tradeResult.setxList(xlist);
//        tradeResult.setyData(ydata);
//
//        return tradeResult;
    }


}
