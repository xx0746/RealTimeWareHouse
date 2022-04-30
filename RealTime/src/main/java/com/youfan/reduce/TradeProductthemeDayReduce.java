package com.youfan.reduce;

import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.product.dws.ProductThemeDws;
import com.youfan.trade.order.dws.TradeProductthemeDay;
import org.apache.flink.api.common.functions.ReduceFunction;

public class TradeProductthemeDayReduce implements ReduceFunction<TradeProductthemeDay> {

    @Override
    public TradeProductthemeDay reduce(TradeProductthemeDay tradeProductthemeDay, TradeProductthemeDay t1) throws Exception {
        long usernums1 = tradeProductthemeDay.getUsernums();
        long usernums2 = tradeProductthemeDay.getUsernums();
        long  numbers1 = tradeProductthemeDay.getNumbers();
        long  numbers2 = tradeProductthemeDay.getNumbers();
        long shopnumbers1 =  tradeProductthemeDay.getShopnumbers();
        long shopnumbers2 =  tradeProductthemeDay.getShopnumbers();
        long  merchartnumbers1 = tradeProductthemeDay.getMerchartnumbers() ;
        long  merchartnumbers2 = tradeProductthemeDay.getMerchartnumbers() ;


        tradeProductthemeDay.setUsernums(usernums1+usernums2);
        tradeProductthemeDay.setNumbers(numbers1+numbers2);
        tradeProductthemeDay.setShopnumbers(shopnumbers1+shopnumbers2);
        tradeProductthemeDay.setMerchartnumbers(merchartnumbers1+merchartnumbers2);
        return tradeProductthemeDay;
    }
}
