/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Support;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ELC-17
 */
public class DatetimeUtils {

    public static final String DATE_FORMAT_SQL = "yyyy-MM-dd hh:mm:ss";
    public static final String DATE_FORMAT_2 = "dd/MM/yyyy";
    public static final String DATE_FORMAT_ISSUE = "dd/MM/yyyy hh:mm";

    public static String convertDateToString(Date date, String format) {
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            return formatter.format(date);
        }
        return "";
    }

    public static Date convertStringToDate(String dateString) {
        if (!dateString.isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            try {
                Date date = formatter.parse(dateString);
                return date;
            } catch (ParseException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    public static Date convertStringToDate(String dateString, String format) {
        if (!dateString.isEmpty()) {
            SimpleDateFormat formatter = new SimpleDateFormat(format);
            try {
                Date date = formatter.parse(dateString);
                return date;
            } catch (ParseException e) {
                return null;
            }
        } else {
            return null;
        }
    }
    
}
