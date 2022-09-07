package com.myfin.util;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class dateTransform {
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static String timestampToDate(long timestamp){
        timestamp = timestamp*1000L;
        return sdf.format(new Date(timestamp));
    }

    public static long dateToTimestamp(String inputDate){
        return sdf.parse(inputDate, new ParsePosition(0)).getTime() / 1000;
    }

    public static String addMonth(String date) throws ParseException {
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        rightNow.add(Calendar.MONTH, 1);
        Date dt1 = rightNow.getTime();
        return sdf.format(dt1);
    }

//    public static void main(String[] args) throws ParseException {
//
//        System.out.println(dateTransform.timestampToDate(1673066588));
//        System.out.println(dateTransform.addMonth("2023-01-07 12:43:08"));
//
//    }
}

