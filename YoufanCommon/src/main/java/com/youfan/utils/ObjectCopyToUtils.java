package com.youfan.utils;
import com.alibaba.fastjson.JSONObject;
import com.youfan.liuLiang.log.PcProductCartLog;
import com.youfan.liuLiang.log.dwd.ProductCartLog;
import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.core.Converter;

public class ObjectCopyToUtils {

    public static void copyto(Object target ,Object source){
        BeanCopier beanCopier = BeanCopier.create(source.getClass(), target.getClass(), false);
        beanCopier.copy(source, target,null);
        System.out.println(JSONObject.toJSONString(target));
    }

    public static void main(String[] args) {
        PcProductCartLog pcProductCartLog = new PcProductCartLog();
        pcProductCartLog.setPindaoId("20");
        pcProductCartLog.setProductTypeId("20");
        pcProductCartLog.setProductId("20");
        pcProductCartLog.setCity("北京");
        ProductCartLog productCartLog = new ProductCartLog();
        copyto(productCartLog,pcProductCartLog);

//        BeanCopier beanCopier = BeanCopier.create(PcProductCartLog.class, ProductCartLog.class, false);
//
//        beanCopier.copy(pcProductCartLog, productCartLog,null);
//        System.out.println(JSONObject.toJSONString(productCartLog));

    }
}
