package util;

import java.util.Date;

public class DateFormat {

    public static String getCurrentDateTime(){
        return getDateTime(new Date());
    }

    public static String getDateTime(Date date) {
        String strFormat = "yyyyÄêMMÔÂddÈÕ E HH:mm:ss";
        return getDateTime(strFormat, date);
    }

    public static String getDateTime(String strFormat, Date date) {
        java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(strFormat);
        return format.format(date);
    }

    public static String getSqlDate() {
        String strFormat = "yyyy-MM-dd HH:mm:ss";
        return getDateTime(strFormat, new Date());
    }

    public static String getDateStr() {
        String strFormat = "yyyy-MM-dd";
        return getDateTime(strFormat, new Date());
    }

}
