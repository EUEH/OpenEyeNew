package com.eueh.openeye.base;

import android.app.Application;
import android.content.Context;

import com.litesuits.orm.LiteOrm;

/**
 * Created by Even on 16/12/28.
 */

public class MyApp extends Application {
    private static Context mContext;
    private static LiteOrm mLiteOrm;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;

    }
    //对外提供一个获取Context对象的方法
    public static Context getmContext() {
        return mContext;
    }

    //自己写一个供LiteTool使用
    public static LiteOrm getmLiteOrm(){
        LiteOrm liteOrm = LiteOrm.newCascadeInstance(mContext , "myLiteorm.db");
        return liteOrm ;
    }

}
