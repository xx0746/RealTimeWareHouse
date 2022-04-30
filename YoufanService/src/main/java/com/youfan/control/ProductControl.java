package com.youfan.control;

import com.youfan.result.ProductResult;
import com.youfan.result.TradeResult;
import com.youfan.service.ProductService;
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
public class ProductControl {

    @Autowired
    private ProductService productService;


    @RequestMapping(value = "productnumberssumQushi",method = RequestMethod.POST)
    public ProductResult productnumberssumQushi(){
//        return productService.product("productnumbers");

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
        datalist.add(556l);
        datalist.add(25l);
        datalist.add(65l);
        datalist.add(16l);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","商品新增趋势");
        map.put("data",datalist);
        ydata.add(map);



        ProductResult productResult = new ProductResult();
        productResult.setxList(xlist);
        productResult.setyData(ydata);

        return productResult;
    }

    @RequestMapping(value = "producttradenumbesQushi",method = RequestMethod.POST)
    public ProductResult producttradenumbesQushi(){
//        return productService.product("producttradenumbes");

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
        datalist.add(556l);
        datalist.add(25l);
        datalist.add(65l);
        datalist.add(16l);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","商品成交趋势");
        map.put("data",datalist);
        ydata.add(map);




        ProductResult productResult = new ProductResult();
        productResult.setxList(xlist);
        productResult.setyData(ydata);

        return productResult;
    }

    @RequestMapping(value = "merchantnumbersQushi",method = RequestMethod.POST)
    public ProductResult merchantnumbersQushi(){
//        return productService.product("merchantnumbers");

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
        datalist.add(556l);
        datalist.add(25l);
        datalist.add(65l);
        datalist.add(16l);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","商家数量趋势");
        map.put("data",datalist);
        ydata.add(map);



        ProductResult productResult = new ProductResult();
        productResult.setxList(xlist);
        productResult.setyData(ydata);

        return productResult;
    }

    @RequestMapping(value = "merchantshopnubmersQushi",method = RequestMethod.POST)
    public ProductResult merchantshopnubmersQushi(){
//        return productService.product("merchantshopnubmers");

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
        datalist.add(556l);
        datalist.add(25l);
        datalist.add(65l);
        datalist.add(16l);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","商家店铺数量趋势");
        map.put("data",datalist);
        ydata.add(map);



        ProductResult productResult = new ProductResult();
        productResult.setxList(xlist);
        productResult.setyData(ydata);

        return productResult;
    }


}
