package com.youfan.utils;

public class MathUtils {

    /**
     * 时间差 单位 秒
     * @param startTime
     * @param endTime
     * @return
     */
    public static long betweenTime(String startTime,String endTime){
        long startTimelong = Long.valueOf(startTime);
        long endTimelong = Long.valueOf(endTime);
        return (endTimelong - startTimelong)/1000l;
    }
}
