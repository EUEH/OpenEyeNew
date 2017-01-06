package com.eueh.openeye.mine;

import android.content.Intent;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.clear.DataCleanManager;
import com.eueh.openeye.clear.MyClearActivity;

import java.util.HashMap;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.PlatformDb;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.tencent.qq.QQ;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

/**
 * Created by dllo on 16/12/19.
 */


public class MineFragment extends BaseFragment implements View.OnClickListener, PlatformActionListener {
    private TextView tvDownLoad, tvNameUser, tvRegist;
    private String num;
    private ImageView ivLogin;
    private String name;
    private String icon;
    private TextView tvCollect;

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {

            if (message.what == 1) {
                Platform platform = (Platform) message.obj;
                PlatformDb platformDb = platform.getDb();

                icon = platformDb.getUserIcon();
                Toast.makeText(getContext(), "收到了", Toast.LENGTH_SHORT).show();

                Glide.with(getContext()).load(icon).bitmapTransform(new CropCircleTransformation(getContext())).into(ivLogin);


            }


            return false;
        }
    });


    @Override
    public int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View view) {

        tvNameUser = (TextView) view.findViewById(R.id.tv_fragment_mine_text_f);
        tvDownLoad = (TextView) view.findViewById(R.id.tv_mine_download);
        ivLogin = (ImageView) view.findViewById(R.id.iv_fragment_mine_pgc_f);
        tvRegist = (TextView) view.findViewById(R.id.tv_regist);

        tvDownLoad.setOnClickListener(this);
        ivLogin.setOnClickListener(this);
        tvRegist.setOnClickListener(this);

        tvCollect = (TextView) view.findViewById(R.id.mine_collect_tv_d);

    }


    @Override
    public void initData() {

        ShareSDK.initSDK(getContext());

        //点击我的收藏进入收藏页面
        cliCollection();

        login();

    }

    //跳转到缓存
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tv_mine_download:
                Intent intent = new Intent(getContext(), MyClearActivity.class);

                try {
                    num = DataCleanManager.getTotalCacheSize(getContext());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                intent.putExtra("num", "缓存大小" + num);
                startActivity(intent);
                break;

            case R.id.iv_fragment_mine_pgc_f:

                //QQ登录
                QQlogin();

                break;

            case R.id.tv_regist:

                QQRegist();

                break;


            case R.id.mine_collect_tv_d:
                Intent intent3 = new Intent(getContext(), MineCollectionActivity.class);
                startActivity(intent3);
                getActivity().overridePendingTransition(R.anim.mine_collection_anim, R.anim.mine_collection_anim);
                break;
        }


    }




    //QQ退出
    private void QQRegist() {
        Platform platform = ShareSDK.getPlatform(QQ.NAME);
        Toast.makeText(getContext(), "退出登录", Toast.LENGTH_SHORT).show();

        platform.removeAccount(true);


    }

    //QQ登录
    private void QQlogin() {

        Platform qq = ShareSDK.getPlatform(QQ.NAME);


        //单独授权,OnComplete返回的hashmap是空的
        //qq.showUser(null);//授权并获取用户信息
        qq.SSOSetting(false);


        qq.setPlatformActionListener(this);
        if (qq.isValid()) {

            qq.removeAccount(true);
        }

        //qq.authorize();
        qq.showUser(null);

    }

    //QQ登录前的准备
    private void login() {

        Platform qq = ShareSDK.getPlatform(QQ.NAME);

        //回调信息，可以在这里获取基本的授权返回的信息，但是注意如果做提示和UI操作要传到主线程handler里去执行

        try {
            PlatformDb platformDb = qq.getDb();
            name = platformDb.getUserName();
            icon = platformDb.getUserIcon();

            if (!TextUtils.isEmpty(name)) {
                tvNameUser.setText(name);
                Glide.with(getContext()).load(icon).bitmapTransform(new CropCircleTransformation(getContext())).into(ivLogin);
            }
        } catch (NullPointerException e) {

        }

    }

    @Override
    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
        Toast.makeText(getActivity(), "收到了sb", Toast.LENGTH_SHORT).show();
        Log.d("MineFragment", "abc");
    }

    @Override
    public void onError(Platform platform, int i, Throwable throwable) {

    }

    @Override
    public void onCancel(Platform platform, int i) {
        Toast.makeText(getActivity(), "取消了", Toast.LENGTH_SHORT).show();

        //点击我的收藏进入收藏页面
        cliCollection();

    }

    private void cliCollection() {
        tvCollect.setOnClickListener(this);

    }


}
