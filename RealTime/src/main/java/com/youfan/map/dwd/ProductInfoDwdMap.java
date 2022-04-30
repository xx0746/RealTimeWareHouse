package com.youfan.map.dwd;

import com.alibaba.fastjson.JSONObject;
import com.youfan.product.dwd.ProductInfoDwd;
import com.youfan.product.ods.ProductInfo;
import com.youfan.utils.HbaesUtils;
import com.youfan.utils.KafkaUtils;
import com.youfan.utils.ObjectCopyToUtils;
import org.apache.flink.api.common.functions.MapFunction;

import java.util.Map;

public class ProductInfoDwdMap implements MapFunction<String, ProductInfoDwd> {

    @Override
    public ProductInfoDwd map(String s) throws Exception {
        ProductInfo productInfo = JSONObject.parseObject(s, ProductInfo.class);

        ProductInfoDwd productInfoDwd = new ProductInfoDwd();
        ObjectCopyToUtils.copyto(productInfoDwd,productInfo);
        String  producttypeName = HbaesUtils.getData("productTypeInfo",productInfo.getProductTypeid()+"","info","producttypeName");
        String  productTypeleave = HbaesUtils.getData("productTypeInfo",productInfo.getProductTypeid()+"","info","productTypeleave");
        String  parentId = HbaesUtils.getData("productTypeInfo",productInfo.getProductTypeid()+"","info","parentId");


        String  shopname = HbaesUtils.getData("shopinfo",productInfo.getShopid()+"","info","shopname");
        String  shopdesc = HbaesUtils.getData("shopinfo",productInfo.getShopid()+"","info","shopdesc");


        String  merchantname = HbaesUtils.getData("merchantinfo",productInfo.getShopid()+"","info","merchantname");
        String  merchantdesc = HbaesUtils.getData("merchantinfo",productInfo.getShopid()+"","info","merchantdesc");

        productInfoDwd.setProductName(producttypeName);
        productInfoDwd.setProductTypeleave(Integer.valueOf(productTypeleave));
        productInfoDwd.setParentId(Long.valueOf(parentId));
        productInfoDwd.setShopname(shopname);
        productInfoDwd.setShopdesc(shopdesc);
        productInfoDwd.setMerchantname(merchantname);
        productInfoDwd.setMerchantdesc(merchantdesc);
        KafkaUtils.sendData("productinfodwm",JSONObject.toJSONString(productInfoDwd));
        return  null;
    }

}
