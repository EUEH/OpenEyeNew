package com.eueh.openeye.concern.concerndetails.concernimage;

import android.content.Intent;
import android.support.v4.view.ViewPager;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

/**
 * Created by 陈小飞 on 16/12/22.
 */

//ViewPager点击跳转后的界面
public class ConcernImageActivity extends BaseActivity{


    private ViewPager concernVpF;
    public static ConcernImageAdapter imageAdapter;

    @Override
    public int setLayout() {
        return R.layout.activity_image_f;
    }

    @Override
    public void initView() {
        concernVpF = (ViewPager) findViewById(R.id.vp_concern_image_f);
        imageAdapter = new ConcernImageAdapter(getSupportFragmentManager());
        concernVpF.setAdapter(imageAdapter);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String url =  intent.getStringExtra("urlMe");
        ConcernImageFragment.Geturl(url);
        NetTool.getInstance().startRequest(url, ConcernImageBean.class, new onHttpCallback<ConcernImageBean>() {
            @Override
            public void onSuccess(ConcernImageBean response) {
                imageAdapter.setConcernImageBean(response);
            }

            @Override
            public void onError(Throwable e) {
            }
        });


    }
}
