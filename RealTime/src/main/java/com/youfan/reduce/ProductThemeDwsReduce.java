package com.youfan.reduce;

import com.youfan.liuLiang.log.dws.ProductthemeDay;
import com.youfan.product.dws.ProductThemeDws;
import org.apache.flink.api.common.functions.ReduceFunction;

public class ProductThemeDwsReduce implements ReduceFunction<ProductThemeDws> {

    @Override
    public ProductThemeDws reduce(ProductThemeDws productThemeDws, ProductThemeDws t1) throws Exception {
        long shopnubmers1 = productThemeDws.getShopnubmers();
        long shopnubmers2 = t1.getShopnubmers();
        long merchatnumbers1 = productThemeDws.getMerchatnumbers();
        long merchatnumbers2 = t1.getMerchatnumbers();
        long numbers1 = productThemeDws.getNumbers();
        long numbers2 = t1.getNumbers();
        long tradenumbes1 = productThemeDws.getTradenumbes();
        long tradenumbes2 = t1.getTradenumbes();
        productThemeDws.setMerchatnumbers(merchatnumbers1+merchatnumbers2);
        productThemeDws.setTradenumbes(tradenumbes1+tradenumbes2);
        productThemeDws.setNumbers(numbers1+numbers2);
        productThemeDws.setShopnubmers(shopnubmers1+shopnubmers2);
        return productThemeDws;
    }
}
