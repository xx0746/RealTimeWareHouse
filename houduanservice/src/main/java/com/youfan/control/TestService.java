package com.youfan.control;

import com.youfan.entity.TubiaoEntity;
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
public class TestService {



    @RequestMapping(value = "tubiao",method = RequestMethod.POST)
    public TubiaoEntity tubiao(){


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
        map.put("name","分类1");
        map.put("data",datalist);
        ydata.add(map);


        datalist = new ArrayList<Long>();
        datalist.add(5l);
        datalist.add(560l);
        datalist.add(215l);
        datalist.add(45l);
        datalist.add(78l);
        map = new HashMap<String,Object>();
        map.put("name","分类2");
        map.put("data",datalist);
        ydata.add(map);
        TubiaoEntity tubiaoEntity = new TubiaoEntity();
        tubiaoEntity.setxList(xlist);
        tubiaoEntity.setyData(ydata);

        return tubiaoEntity;
    }
}
