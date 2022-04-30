package com.youfan.control;

import com.youfan.result.LiuliangResult;
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
public class LiuliangControl {

@Autowired
private LiuliangService liuliangService;

    @RequestMapping(value = "productCartPv",method = RequestMethod.POST)
    public LiuliangResult productCartPv(){
        return liuliangService.productCart("pv");


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
//        datalist.add(56l);
//        datalist.add(25l);
//        datalist.add(35l);
//        datalist.add(16l);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","添加操作");
//        map.put("data",datalist);
//        ydata.add(map);
//
//
//        datalist = new ArrayList<Long>();
//        datalist.add(5l);
//        datalist.add(560l);
//        datalist.add(215l);
//        datalist.add(45l);
//        datalist.add(78l);
//        map = new HashMap<String,Object>();
//        map.put("name","删除操作");
//        map.put("data",datalist);
//        ydata.add(map);
//        LiuliangResult liuliangResult = new LiuliangResult();
//        liuliangResult.setxList(xlist);
//        liuliangResult.setyData(ydata);
//
//        return liuliangResult;
    }

    @RequestMapping(value = "productCartUv",method = RequestMethod.POST)
    public LiuliangResult productCartUv(){

        return liuliangService.productCart("uv");
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
//        datalist.add(56l);
//        datalist.add(25l);
//        datalist.add(357l);
//        datalist.add(16l);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","添加操作");
//        map.put("data",datalist);
//        ydata.add(map);
//
//
//        datalist = new ArrayList<Long>();
//        datalist.add(5l);
//        datalist.add(560l);
//        datalist.add(25l);
//        datalist.add(45l);
//        datalist.add(78l);
//        map = new HashMap<String,Object>();
//        map.put("name","删除操作");
//        map.put("data",datalist);
//        ydata.add(map);
//        LiuliangResult liuliangResult = new LiuliangResult();
//        liuliangResult.setxList(xlist);
//        liuliangResult.setyData(ydata);
//
//        return liuliangResult;
    }

    @RequestMapping(value = "productCartproductNums",method = RequestMethod.POST)
    public LiuliangResult productCartproductNums(){
//        return liuliangService.productCart("productnums");

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
        datalist.add(357l);
        datalist.add(16l);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","添加操作");
        map.put("data",datalist);
        ydata.add(map);


        datalist = new ArrayList<Long>();
        datalist.add(5l);
        datalist.add(560l);
        datalist.add(25l);
        datalist.add(45l);
        datalist.add(78l);
        map = new HashMap<String,Object>();
        map.put("name","删除操作");
        map.put("data",datalist);
        ydata.add(map);
        LiuliangResult liuliangResult = new LiuliangResult();
        liuliangResult.setxList(xlist);
        liuliangResult.setyData(ydata);

        return liuliangResult;
    }


    /**
     * 终端分析
     *
     */



    @RequestMapping(value = "divicePv",method = RequestMethod.POST)
    public LiuliangResult divicePv(){
        return liuliangService.device("pv");

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
//        datalist.add(56l);
//        datalist.add(25l);
//        datalist.add(35l);
//        datalist.add(16l);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","PC端");
//        map.put("data",datalist);
//        ydata.add(map);
//
//
//        datalist = new ArrayList<Long>();
//        datalist.add(5l);
//        datalist.add(560l);
//        datalist.add(215l);
//        datalist.add(45l);
//        datalist.add(78l);
//        map = new HashMap<String,Object>();
//        map.put("name","移动端");
//        map.put("data",datalist);
//        ydata.add(map);
//        LiuliangResult liuliangResult = new LiuliangResult();
//        liuliangResult.setxList(xlist);
//        liuliangResult.setyData(ydata);
//
//        return liuliangResult;
    }

    @RequestMapping(value = "diviceUv",method = RequestMethod.POST)
    public LiuliangResult diviceUv(){
        return liuliangService.device("uv");


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
//        datalist.add(56l);
//        datalist.add(25l);
//        datalist.add(357l);
//        datalist.add(16l);
//        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("name","PC端");
//        map.put("data",datalist);
//        ydata.add(map);
//
//
//        datalist = new ArrayList<Long>();
//        datalist.add(5l);
//        datalist.add(560l);
//        datalist.add(25l);
//        datalist.add(45l);
//        datalist.add(78l);
//        map = new HashMap<String,Object>();
//        map.put("name","移动端");
//        map.put("data",datalist);
//        ydata.add(map);
//        LiuliangResult liuliangResult = new LiuliangResult();
//        liuliangResult.setxList(xlist);
//        liuliangResult.setyData(ydata);
//
//        return liuliangResult;
    }

    @RequestMapping(value = "diviceproductNums",method = RequestMethod.POST)
    public LiuliangResult diviceproductNums(){
//        return liuliangService.device("productnums");
//
//
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
        datalist.add(357l);
        datalist.add(16l);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","PC端");
        map.put("data",datalist);
        ydata.add(map);


        datalist = new ArrayList<Long>();
        datalist.add(5l);
        datalist.add(560l);
        datalist.add(25l);
        datalist.add(45l);
        datalist.add(78l);
        map = new HashMap<String,Object>();
        map.put("name","移动端");
        map.put("data",datalist);
        ydata.add(map);
        LiuliangResult liuliangResult = new LiuliangResult();
        liuliangResult.setxList(xlist);
        liuliangResult.setyData(ydata);

        return liuliangResult;
    }
}
