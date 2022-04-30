package com.youfan.reduce;

import com.youfan.liuLiang.log.dws.ProductthemeDay;
import org.apache.flink.api.common.functions.ReduceFunction;

public class ProductthemeDayReduce implements ReduceFunction<ProductthemeDay> {
    @Override
    public ProductthemeDay reduce(ProductthemeDay productthemeDay, ProductthemeDay t1) throws Exception {
        long devicenums1 = productthemeDay.getDevicenums();
        long devicenums2 = t1.getDevicenums();

        long operatornumbers1 = productthemeDay.getOperatornums();
        long operatornumbers2 = t1.getOperatornums();


        long  scanproducttotal1 = productthemeDay.getScanproducttotal();
        long  scanproducttotal2 = t1.getScanproducttotal();

        long scanproducttotaltime1 = productthemeDay.getScanproducttotaltime();
        long  scanproducttotaltime2 = t1.getScanproducttotaltime();

        long usernums1 = productthemeDay.getUsernums();
        long  usernums2 = t1.getUsernums();

        productthemeDay.setDevicenums(devicenums1+devicenums2);
        productthemeDay.setUsernums(usernums1+usernums2);
        productthemeDay.setOperatornums(operatornumbers1+operatornumbers2);
        productthemeDay.setScanproducttotal(scanproducttotal1+scanproducttotal2);
        productthemeDay.setScanproducttotaltime(scanproducttotaltime1+scanproducttotaltime2);
        return productthemeDay;
    }
}
