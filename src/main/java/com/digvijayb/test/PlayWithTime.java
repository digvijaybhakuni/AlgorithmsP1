package com.digvijayb.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by digvijayb on 26/6/15.
 */
public class PlayWithTime {


    static final boolean isLeapYear(int var0) {
        return (var0 & 3) == 0 && (var0 % 100 != 0 || var0 % 400 == 0);
    }

    public static void main(String... arg){


        boolean b = isLeapYear(2012);

        System.out.println((0 & 3));

        for(int i = 1; i < 33; i++) {
            System.out.println((i & 3) +" "+(i % 3)+ " " + i);
        }
        System.out.println(b);

        for(int i = 0 ; i <= 10; i++){
            //System.out.println(String.format("%010d",Integer.parseInt(Integer.toBinaryString(i))));
            //System.out.println(Integer.toBinaryString(i)+" \t " + Integer.parseInt(Integer.toBinaryString(i)) + " \t " + i);

            System.out.printf("%010d", Integer.parseInt(Integer.toBinaryString(i)));
            System.out.println();
            //System.out.printf("%010s", Integer.toBinaryString(i));
            //System.out.println();
        }

        Date now = new Date();

        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        df.setTimeZone(TimeZone.getTimeZone("CST"));

        System.out.println("timeZone.......-->>>>>>" + df.format(now));
        System.out.println("timeZone.......-->>>>>>" + df.getCalendar().getTime());

        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone(ZoneId.of("America/Phoenix")));
        TimeZone fromTimeZone = calendar.getTimeZone();
        TimeZone toTimeZone = TimeZone.getTimeZone("CST");

        calendar.setTimeZone(fromTimeZone);
        calendar.add(Calendar.MILLISECOND, fromTimeZone.getRawOffset() * -1);
        if (fromTimeZone.inDaylightTime(calendar.getTime())) {
            calendar.add(Calendar.MILLISECOND, calendar.getTimeZone().getDSTSavings() * -1);
        }

        calendar.add(Calendar.MILLISECOND, toTimeZone.getRawOffset());
        if (toTimeZone.inDaylightTime(calendar.getTime())) {
            calendar.add(Calendar.MILLISECOND, toTimeZone.getDSTSavings());
        }

        Date calendarTime = calendar.getTime();
        System.out.println(df.format(calendarTime));


        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("America/Chicago"));
        //ZoneId zoneId =new ZoneId();
        System.out.println(c.getTime());



    }


}
