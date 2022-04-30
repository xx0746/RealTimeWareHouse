package com.youfan.reduce;

import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.product.dws.MerchatnubmerThemeDws;
import org.apache.flink.api.common.functions.ReduceFunction;

public class MerchatnubmerThemeDwsReduce implements ReduceFunction<MerchatnubmerThemeDws> {


    @Override
    public MerchatnubmerThemeDws reduce(MerchatnubmerThemeDws merchatnubmerThemeDws, MerchatnubmerThemeDws t1) throws Exception {
        long nubemrs1 = merchatnubmerThemeDws.getNumbers();
        long nubemrs2 = t1.getNumbers();
        long shopnubmers1 = merchatnubmerThemeDws.getShopnubmers();
        long shopnubmers2 = t1.getShopnubmers();
        long tradenumbes1 = merchatnubmerThemeDws.getTradenumbes();
        long tradenumbes2 = t1.getTradenumbes();

        merchatnubmerThemeDws.setShopnubmers(shopnubmers1+shopnubmers2);
        merchatnubmerThemeDws.setTradenumbes(tradenumbes1+tradenumbes2);
        merchatnubmerThemeDws.setNumbers(nubemrs1+nubemrs2);
        return merchatnubmerThemeDws;
    }
}
