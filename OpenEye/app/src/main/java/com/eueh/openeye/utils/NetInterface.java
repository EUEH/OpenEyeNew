package com.eueh.openeye.utils;

/**
 * Created by FBD小组 on 16/12/20.
 */
public interface NetInterface {
    //解析单独网址的接口
    void startRequest(String url, onHttpCallback<String> callback);
    //解析Get请求的接口
    <T> void startRequest(String url, Class<T> tClass, onHttpCallback<T> callback);

}
