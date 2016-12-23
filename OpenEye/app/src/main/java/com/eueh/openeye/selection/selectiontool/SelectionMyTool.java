package com.eueh.openeye.selection.selectiontool;

import java.text.SimpleDateFormat;

/**
 * Created by 陈焕栋 on 16/12/22.
 */

public class SelectionMyTool {

    //日期格式更正  成分秒模式

    public static final String intoTime(Long time){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String timeNew = simpleDateFormat.format(Long.valueOf(time));
        String min = timeNew.substring(14, 19);
        return min ;
    }




}
