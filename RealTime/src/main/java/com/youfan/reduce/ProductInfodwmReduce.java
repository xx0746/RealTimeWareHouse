package com.youfan.reduce;

import com.youfan.product.dwm.ProductInfoDwm;
import org.apache.flink.api.common.functions.ReduceFunction;

public class ProductInfodwmReduce implements ReduceFunction<ProductInfoDwm> {
    @Override
    public ProductInfoDwm reduce(ProductInfoDwm productInfoDwm, ProductInfoDwm t1) throws Exception {
        long nubmers1 = productInfoDwm.getNumbers();
        long numbers2 = t1.getNumbers();
        long tradenumbers1 = productInfoDwm.getTradenumbes();
        long tradenumbers2 = t1.getTradenumbes();
        productInfoDwm.setNumbers(numbers2+nubmers1);
        productInfoDwm.setTradenumbes(tradenumbers1+tradenumbers2);
        return  productInfoDwm;
    }
}
