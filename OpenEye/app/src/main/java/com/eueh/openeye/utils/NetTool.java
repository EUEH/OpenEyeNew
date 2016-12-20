package com.eueh.openeye.utils;

/**
 * Created by FBD小组 on 16/12/20.
 */

public class NetTool implements NetInterface {
    private static NetTool ourInstance ;

    public static NetTool getInstance() {
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
}
