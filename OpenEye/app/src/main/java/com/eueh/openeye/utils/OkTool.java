package com.eueh.openeye.utils;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by FBD小组 on 16/12/20.
 */
public class OkTool implements NetInterface {

    private OkHttpClient mClient;
    //主线程的Looper对象  系统帮你建好了   保证用的都是主线程的Looper对象
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private Gson mGson;


    public OkTool() {
        super();
        mGson = new Gson();
        //初始化OkHttpClient
        //String path = Environment.getExternalStorageDirectory()+"/OK";
        //缓存路径SD卡
        File cacheDir = Environment.getExternalStorageDirectory();
        mClient = new OkHttpClient.Builder()
                //设置缓存最大大小为10M
                .cache(new Cache(cacheDir, 10 * 1024 * 1024))
                //设置连接超时  超过时间不再请求
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    //解析单个网址的构造方法
    //原来的把@Override不小心删了
    @Override
    public void startRequest(String url, final onHttpCallback<String> callback) {
        Request request = new Request.Builder().url(url).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(final Call call, final IOException e) {
                //用主线程的Handler  把错误的信息发送
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(final Call call, Response response) throws IOException {
                final String result = response.body().string();

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(result);
                    }
                });
            }
        });
    }

    //解析Get请求网址的构造方法
    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final onHttpCallback<T> callback) {
        Request request = new Request.Builder().url(url).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                final T result = mGson.fromJson(str,tClass);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(result);
                    }
                });
            }
        });
    }

    //Post请求的构造方法
    @Override  //这种方法解决不了有很多组key  value  的情况
    public <T> void startRequest(String url,String key,String value, final Class<T> tClass, final onHttpCallback<T> callback) {
        FormBody formBody = new FormBody.Builder().add(key , value).build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                final T result = mGson.fromJson(str,tClass);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(result);
                    }
                });
            }
        });
    }


    //new
    @Override
    public <T> void startRequest(String url, HashMap<String, String> map, final Class<T> tClass, final onHttpCallback<T> callback) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String s : map.keySet()) {
            builder.add(s , map.get(s) );
        }
        FormBody body = builder.build();
        Request request = new Request.Builder().url(url).post(body).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                final T result = mGson.fromJson(str, tClass);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(result);
                    }
                });
            }
        });

    }





}
