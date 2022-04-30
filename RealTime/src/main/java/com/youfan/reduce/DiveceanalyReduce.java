package com.youfan.reduce;

import com.youfan.liuLiang.log.app.Diveceanaly;
import org.apache.flink.api.common.functions.ReduceFunction;

public class DiveceanalyReduce implements ReduceFunction<Diveceanaly> {
    @Override
    public Diveceanaly reduce(Diveceanaly diveceanaly, Diveceanaly t1) throws Exception {
        long pv1 =  diveceanaly.getPv();
        long pv2 =  t1.getPv();
        long uv1 = diveceanaly.getUv();
        long uv2 = t1.getUv();
        long productnums1 = diveceanaly.getProductnums();
        long productnums2 = t1.getProductnums();
        diveceanaly.setPv(pv1+pv2);
        diveceanaly.setUv(uv1+uv2);
        diveceanaly.setProductnums(productnums1+productnums2);
        return diveceanaly;
    }
}
