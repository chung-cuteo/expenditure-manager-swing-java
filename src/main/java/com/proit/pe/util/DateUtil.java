package com.proit.pe.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static final String pattern = "dd/MM/yyyy";
    private static final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
    
    public  static String toString(Date date){
        return sdf.format(date);
    }
    
    public static Date toDate(String stDate) throws ParseException{
        return sdf.parse(stDate);
    }
}
