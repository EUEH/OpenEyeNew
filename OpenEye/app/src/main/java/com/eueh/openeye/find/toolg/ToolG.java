package com.eueh.openeye.find.toolg;

/**
 * Created by Even on 16/12/22.
 */

public class ToolG {

    //webView 截取 url= 之后的字符串(网址)
    public static String subString(String string){
        if (string.indexOf("url=")!=-1){
            String result = string.substring(string.indexOf("url=")+4,string.length());
            return result;
        }else {
            return "";
        }
    }

}
