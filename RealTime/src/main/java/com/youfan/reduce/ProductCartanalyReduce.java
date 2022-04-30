package com.youfan.reduce;

import com.youfan.liuLiang.log.app.ProductCartanaly;
import org.apache.flink.api.common.functions.ReduceFunction;

public class ProductCartanalyReduce implements ReduceFunction<ProductCartanaly> {
    @Override
    public ProductCartanaly reduce(ProductCartanaly productCartanaly, ProductCartanaly t1) throws Exception {
        long pv1 = productCartanaly.getPv();
        long pv2 = t1.getPv();
        long uv1 = productCartanaly.getUv();
        long uv2 = t1.getUv();
        long productnums1 = productCartanaly.getProductnums();
        long productnums2 = t1.getProductnums();
        productCartanaly.setPv(pv1+pv2);
        productCartanaly.setUv(uv1+uv2);
        productCartanaly.setProductnums(productnums1+productnums2);
        return productCartanaly;
    }
}
