package com.demo.util;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 时间处理工具类
 */
public class DateTools {

    /**
     * 当前时间格式:yyyy-MM-dd HH:mm:ss
     */
    public static final String CURRENT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";


    /**
     * 获取当前系统时间
     * @return  yyyy-MM-dd HH:mm:ss
     */
    public static String getCurrentTime(){
        SimpleDateFormat formatter = new SimpleDateFormat(CURRENT_TIME_FORMAT);
        Date currentTime = new Date();
        return formatter.format(currentTime);
    }

}

