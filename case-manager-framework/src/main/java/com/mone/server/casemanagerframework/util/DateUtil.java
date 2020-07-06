package com.mone.server.casemanagerframework.util;

import com.mone.server.config.constant.DatePattern;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Classname DateUtil
 * @auther motao
 * @create 2020-07-06 18:01
 */
public class DateUtil {

    public static String getDateString(Date date){
        if (date == null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DatePattern.YYYY_MM_DD);
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }

    public static String getDateTimeString(Date date){
        if (date == null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DatePattern.YYYY_MM_DD_HH_MM_SS);
        String dateString = simpleDateFormat.format(date);
        return dateString;
    }
}
