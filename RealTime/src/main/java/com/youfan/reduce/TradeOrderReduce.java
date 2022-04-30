package com.youfan.reduce;

import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.trade.order.dwm.YouFanOrderDwmDay;
import org.apache.flink.api.common.functions.ReduceFunction;

public class TradeOrderReduce implements ReduceFunction<YouFanOrderDwmDay> {
    @Override
    public YouFanOrderDwmDay reduce(YouFanOrderDwmDay youFanOrderDwmDay, YouFanOrderDwmDay t1) throws Exception {
        long numbers1 = youFanOrderDwmDay.getNumbers();
        long numbers2 = t1.getNumbers();
       double orderAmountTotal1 = youFanOrderDwmDay.getOrderAmountTotal();
        double orderAmountTotal2 = t1.getOrderAmountTotal();
         double payAmountTotal = youFanOrderDwmDay.getPayAmountTotal();
        double payAmountTotal2 = t1.getPayAmountTotal();
        youFanOrderDwmDay.setNumbers(numbers1+numbers2);
        youFanOrderDwmDay.setOrderAmountTotal(orderAmountTotal1+orderAmountTotal2);
        youFanOrderDwmDay.setPayAmountTotal(payAmountTotal+payAmountTotal2);
        return youFanOrderDwmDay;
    }
}
