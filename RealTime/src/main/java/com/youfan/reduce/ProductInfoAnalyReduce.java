package com.youfan.reduce;

import com.alibaba.fastjson.JSONObject;
import com.youfan.product.app.ProductinfoApp;
import com.youfan.product.dws.MerchatnubmerThemeDws;
import com.youfan.product.dws.ProductThemeDws;
import com.youfan.utils.DateUtils;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.functions.ReduceFunction;

import java.util.Date;

public class ProductInfoAnalyReduce implements ReduceFunction<ProductinfoApp> {


    @Override
    public ProductinfoApp reduce(ProductinfoApp productinfoApp, ProductinfoApp t1) throws Exception {
        long merchantnumbers1 = productinfoApp.getMerchantnumbers();
        long merchantnumbers2 = productinfoApp.getMerchantnumbers();
        long productnumbers1 = productinfoApp.getProductnumbers();
        long productnumbers2 = productinfoApp.getProductnumbers();
        long producttradenumbes1 = productinfoApp.getProducttradenumbes();
        long producttradenumbes2 = productinfoApp.getProducttradenumbes();
        long merchantshopnubmers1 = productinfoApp.getMerchantshopnubmers();
        long merchantshopnubmers2 = productinfoApp.getMerchantshopnubmers();
        productinfoApp.setProducttradenumbes(producttradenumbes1+producttradenumbes2);
        productinfoApp.setMerchantnumbers(merchantnumbers1+merchantnumbers2);
        productinfoApp.setProductnumbers(productnumbers1+productnumbers2);
        productinfoApp.setMerchantshopnubmers(merchantshopnubmers1+merchantshopnubmers2);
        return productinfoApp;
    }
}
