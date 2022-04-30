package com.youfan.reduce;

import com.youfan.liuLiang.log.dwm.ProductCartStatitisDay;
import com.youfan.liuLiang.log.dwm.ProducthuodongStatitisDay;
import org.apache.flink.api.common.functions.ReduceFunction;

public class ProductHuodongStatitisReduce implements ReduceFunction<ProducthuodongStatitisDay> {

    @Override
    public ProducthuodongStatitisDay reduce(ProducthuodongStatitisDay producthuodongStatitisDay, ProducthuodongStatitisDay t1) throws Exception {
        long scanTims1 = producthuodongStatitisDay.getScantimes();
        long timetotals1 = producthuodongStatitisDay.getScanTimetotals();

        long scanTims2 = t1.getScantimes();
        long timetotals2 = t1.getScanTimetotals();

        producthuodongStatitisDay.setScantimes(scanTims1+scanTims2);
        producthuodongStatitisDay.setScanTimetotals(timetotals1+timetotals2);
        return producthuodongStatitisDay;
    }
}
