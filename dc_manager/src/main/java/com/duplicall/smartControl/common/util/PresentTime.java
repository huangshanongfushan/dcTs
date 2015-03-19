package com.duplicall.smartControl.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 
 * <一句话功能简述>
 * 
 * @author mli
 * @version [V1.00, 2014年7月11日]
 * @see [reference class/method]
 * @since V1.00
 */
public class PresentTime
{
    /**
     * 获取当前时间并格式化
     * <function>
     * <description>
     * 
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String presentTime()
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String time = format.format(calendar.getTime());
        return time;
    }
}
