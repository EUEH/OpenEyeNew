package com.eueh.openeye.utils;

/**
 * Created by FBD小组 on 16/12/20.
 */
//单例的类
public class NetTool implements NetInterface {

    private static NetTool ourInstance ;

    public static NetTool getInstance() {
        //双重校验锁
        if (ourInstance == null){
            synchronized (NetTool.class){
                if (ourInstance == null){
                    ourInstance = new NetTool();
                }
            }
        }
        return ourInstance;
    }


    private NetInterface mInterface;

    private NetTool() {
        mInterface = new OkTool();
    }

    @Override
    public void startRequest(String url, onHttpCallback<String> callback) {
        mInterface.startRequest(url,callback);
    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, onHttpCallback<T> callback) {
        mInterface.startRequest(url,tClass,callback);
    }

    @Override
    public <T> void startRequest(String url,String key,String value, final Class<T> tClass , onHttpCallback<T> callback){
        mInterface.startRequest(url , key , value , tClass , callback );
    }


}
