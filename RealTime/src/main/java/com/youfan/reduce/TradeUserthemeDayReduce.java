package com.youfan.reduce;

import com.youfan.liuLiang.log.dws.UserthemeDay;
import com.youfan.trade.order.dws.TradeUserthemeDay;
import org.apache.flink.api.common.functions.ReduceFunction;

public class TradeUserthemeDayReduce implements ReduceFunction<TradeUserthemeDay> {
    @Override
    public TradeUserthemeDay reduce(TradeUserthemeDay userthemeDay, TradeUserthemeDay t1) throws Exception {
        long productnums1 = userthemeDay.getProductnums();
        long productnums2 = t1.getProductnums();

        long  numbers1=  userthemeDay.getNumbers();
        long  numbers2=  userthemeDay.getNumbers();
        long shopnumbers1 =  userthemeDay.getShopnumbers();
        long shopnumbers2 =  userthemeDay.getShopnumbers();
        long  merchartnumbers1 =  userthemeDay.getMerchartnumbers() ;
        long  merchartnumbers2 = userthemeDay.getMerchartnumbers() ;

        double orderAmountTotal1 = userthemeDay.getTotalAmount();
        double orderAmountTotal2 = t1.getTotalAmount();

        userthemeDay.setNumbers(numbers1+numbers2);
        userthemeDay.setProductnums(productnums1+productnums2);
        userthemeDay.setMerchartnumbers(merchartnumbers1+merchartnumbers2);
        userthemeDay.setShopnumbers(shopnumbers1+shopnumbers2);
        userthemeDay.setTotalAmount(orderAmountTotal1+orderAmountTotal2);


        return userthemeDay;
    }
}
