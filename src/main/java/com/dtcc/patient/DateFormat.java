package com.dtcc.patient;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {

    public static Date covertStringToDate(String s, String format) throws Exception{
        Date d = new SimpleDateFormat(format).parse(s);
        return d;
    }
    public static String convertDateToString(Date d, String format) throws Exception{
        String s = new SimpleDateFormat(format).format(d);
        return s;
    }
}
