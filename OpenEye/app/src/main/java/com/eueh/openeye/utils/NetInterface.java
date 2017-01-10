package com.eueh.openeye.utils;

import java.util.HashMap;

/**
 * Created by FBD小组 on 16/12/20.
 */
public interface NetInterface {

    //解析单独网址的接口
    void startRequest(String url, onHttpCallback<String> callback);
    //解析Get请求的接口
    <T> void startRequest(String url, Class<T> tClass, onHttpCallback<T> callback);

    //解析Post请求的接口
    <T> void startRequest(String url, String key, String value, Class<T> tClass, onHttpCallback<T> callback);

    //解析Post请求的接口   构造方法里面放的是map
    <T> void startRequest(String url , HashMap<String , String> map , Class<T> tClass , onHttpCallback<T> callback);

}
