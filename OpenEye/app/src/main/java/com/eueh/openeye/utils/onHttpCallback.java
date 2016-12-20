package com.eueh.openeye.utils;

/**
 * Created by FBD小组 on 16/12/20.
 */
public interface onHttpCallback<T> {
    //成功回调
    void onSuccess(T response);
    //失败回调
    void onError(Throwable e);
}
