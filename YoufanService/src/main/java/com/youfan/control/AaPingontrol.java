package com.youfan.control;

import com.alibaba.fastjson.JSONObject;
import com.youfan.result.DaPingResult;
import com.youfan.result.LiuliangResult;
import com.youfan.service.DaPingService;
import com.youfan.service.LiuliangService;
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
public class AaPingontrol {

@Autowired
private DaPingService daPingService;

    @RequestMapping(value = "productTypeTrade",method = RequestMethod.POST)
    public DaPingResult productTypeTrade(){
//        return  daPingService.productTypeTrade();
        List<String> xlist = new ArrayList<String>();
        xlist.add("20200905");
        xlist.add("20200906");
        xlist.add("20200907");
        xlist.add("20200908");
        xlist.add("20200909");
        xlist.add("20200910");

        List<Map<String,Object>> ydata = new ArrayList<Map<String,Object>>();
        List<Long> datalist = new ArrayList<Long>();
        datalist.add(45l);
        datalist.add(56l);
        datalist.add(25l);
        datalist.add(35l);
        datalist.add(16l);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","生活用品");
        map.put("data",datalist);
        map.put("type","line");
        map.put("stack","总量");
        ydata.add(map);

        datalist = new ArrayList<Long>();
        datalist.add(5l);
        datalist.add(560l);
        datalist.add(215l);
        datalist.add(45l);
        datalist.add(78l);
        map = new HashMap<String,Object>();
        map.put("name","电脑配件");
        map.put("data",datalist);
        map.put("type","line");
        map.put("stack","总量");
        ydata.add(map);
        DaPingResult daPingResult = new DaPingResult();
        daPingResult.setxList(xlist);
        daPingResult.setyData(ydata);

        return daPingResult;


    }

    @RequestMapping(value = "realTimeTrade",method = RequestMethod.POST)
    public DaPingResult realTimeTrade(){
//        return daPingService.realTimeTrade();
        System.out.println("haha");
        List<List<String>> datalistfinal = new ArrayList<List<String>>();
        List<String> datalist = new ArrayList<String>();
        datalist.add("黑管唇釉416号11");
        datalist.add("美妆");
        datalist.add("<span  class='colorGrass'>1045</span>");
        datalistfinal.add(datalist);
        datalist = new ArrayList<String>();
        datalist.add("南极人NanJiren 全棉四件套11");
        datalist.add("家居");
        datalist.add("<span  class='colorGrass'>245</span>");
        datalistfinal.add(datalist);
        DaPingResult daPingResult = new DaPingResult();
        daPingResult.setTradeList(datalistfinal);
        daPingResult.setTradeListString(JSONObject.toJSONString(datalistfinal));

        return daPingResult;


    }
}
