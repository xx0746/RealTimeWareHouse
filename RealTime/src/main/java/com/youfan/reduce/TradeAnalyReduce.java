package com.youfan.reduce;

import com.youfan.liuLiang.log.app.Diveceanaly;
import com.youfan.trade.order.app.TradeApp;
import org.apache.flink.api.common.functions.ReduceFunction;

public class TradeAnalyReduce implements ReduceFunction<TradeApp> {
    @Override
    public TradeApp reduce(TradeApp tradeApp, TradeApp t1) throws Exception {

        long usernumser1 = tradeApp.getUsernumser();//订单用户数
        long usernumser2 = t1.getUsernumser();//订单用户数
        long ordernumbers1 = tradeApp.getOrdernumbers();//订单数
        long ordernumbers2 = t1.getOrdernumbers();//订单数
        double totalAmount1 = tradeApp.getTotalAmount();//总金额
        double totalAmount2 = t1.getTotalAmount();//总金额
        long productnumser1 = tradeApp.getProductnumser();//成交商品数
        long productnumser2 = t1.getProductnumser();//成交商品数

        tradeApp.setProductnumser(productnumser1+productnumser2);
        tradeApp.setTotalAmount(totalAmount1+totalAmount2);
        tradeApp.setOrdernumbers(ordernumbers1+ordernumbers2);
        tradeApp.setUsernumser(usernumser1+usernumser2);
        return tradeApp;
    }
}
