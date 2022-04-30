package com.youfan.reduce;

import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import org.apache.flink.api.common.functions.ReduceFunction;

public class ProductCartStatitisReduce implements ReduceFunction<ProductCartStatitisDay> {
    @Override
    public ProductCartStatitisDay reduce(ProductCartStatitisDay productCartStatitisDay, ProductCartStatitisDay t1) throws Exception {
        long operatorTimes1 = productCartStatitisDay.getOperatorTimes();
        long operatorTimes2 = t1.getOperatorTimes();
        productCartStatitisDay.setOperatorTimes(operatorTimes1+operatorTimes2);
        return productCartStatitisDay;
    }
}
