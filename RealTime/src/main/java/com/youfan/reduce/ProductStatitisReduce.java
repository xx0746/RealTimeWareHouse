package com.youfan.reduce;

import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProductStatitisDay;
import org.apache.flink.api.common.functions.ReduceFunction;

public class ProductStatitisReduce implements ReduceFunction<ProductStatitisDay> {

    @Override
    public ProductStatitisDay reduce(ProductStatitisDay productStatitisDay, ProductStatitisDay t1) throws Exception {
        long times1 = productStatitisDay.getScantimes();
        long time2 = t1.getScantimes();

        long totalTime1 = productStatitisDay.getScanTimetotals();
        long totalTime2 = t1.getScanTimetotals();

        productStatitisDay.setScantimes(times1+time2);
        productStatitisDay.setScanTimetotals(totalTime1+totalTime2);

        return productStatitisDay;
    }
}
