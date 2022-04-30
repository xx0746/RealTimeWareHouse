package com.youfan.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static  String transferDate(Date date , String dateFormat){
        DateFormat dateFormat1 = new SimpleDateFormat(dateFormat);
        return  dateFormat1.format(date);
    }

    public static int compareDate(String date1,String date2,String dateformat){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateformat);
        try {
            Date date11 = simpleDateFormat.parse(date1);
            Date date22 = simpleDateFormat.parse(date2);
            return  date11.compareTo(date22);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;


    }

    public static  String transferDate(long datetime, String dateFormat){
        DateFormat dateFormat1 = new SimpleDateFormat(dateFormat);
        return  dateFormat1.format(new Date(datetime));
    }
}
