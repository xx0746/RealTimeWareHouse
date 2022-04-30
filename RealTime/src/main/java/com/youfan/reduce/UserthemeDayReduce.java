package com.youfan.reduce;

import com.youfan.liuLiang.log.dws.UserthemeDay;
import org.apache.flink.api.common.functions.ReduceFunction;

public class UserthemeDayReduce implements ReduceFunction<UserthemeDay> {
    @Override
    public UserthemeDay reduce(UserthemeDay userthemeDay, UserthemeDay t1) throws Exception {
        long devicenums1= userthemeDay.getDevicenums();
        long devicenums2 = t1.getDevicenums();

        long operatornumbers1 = userthemeDay.getOperatornumbers();
        long operatornumbers2 = t1.getOperatornumbers();

        long deviceTypenumbers1 = userthemeDay.getDeviceTypenumbers();
        long deviceTypenumbers2 = t1.getDeviceTypenumbers();

        long scanhuodongnums1 = userthemeDay.getScanhuodongnums();
long scanhuodongnums2 = t1.getScanhuodongnums();

long scanproudctnums1 = userthemeDay.getScanproudctnums();
        long scanproudctnums2 = t1.getScanproudctnums();

        long scanproducttypenums1   = userthemeDay.getScanproducttypenums();
        long scanproducttypenums2   = t1.getScanproducttypenums();

        long scanpingdaonums1   = userthemeDay.getScanpingdaonums();
        long scanpingdaonums2   = t1.getScanpingdaonums();

        long  scanproducttotal1   = userthemeDay.getScanproducttotal();
        long  scanproducttotal2   = t1.getScanproducttotal();

        userthemeDay.setDevicenums(devicenums1+devicenums2);
        userthemeDay.setOperatornumbers(operatornumbers1+operatornumbers2);
        userthemeDay.setScanpingdaonums(scanpingdaonums1+scanpingdaonums2);
        userthemeDay.setScanhuodongnums(scanhuodongnums1+scanhuodongnums2);
        userthemeDay.setScanproudctnums(scanproudctnums1+scanproudctnums2);
        userthemeDay.setScanproducttypenums(scanproducttypenums1+scanproducttypenums2);
        userthemeDay.setDeviceTypenumbers(deviceTypenumbers1+deviceTypenumbers2);
        userthemeDay.setScanproducttotal(scanproducttotal1+scanproducttotal2);
        return userthemeDay;
    }
}
