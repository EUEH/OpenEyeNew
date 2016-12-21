package com.eueh.openeye.concern;

import java.text.SimpleDateFormat;

/**
 * Created by 陈小飞 on 16/12/21.
 */

public class TimeConversion {

    //转换时间
    public static String conversionTime(Long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = sdf.format(time);
        return str;
    }
}
