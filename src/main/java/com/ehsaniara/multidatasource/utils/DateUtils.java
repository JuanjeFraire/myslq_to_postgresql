package com.ehsaniara.multidatasource.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static Date getCurrentDateTime(){
        Calendar c = Calendar.getInstance();
        return c.getTime();
    }

    public static Date getCurrentDateWithHoursSubstracted(Integer hoursToSubstract){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.HOUR, -hoursToSubstract);
        return c.getTime();
    }

    public static String getDateAsString(Date date, String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(date);
    }

}
