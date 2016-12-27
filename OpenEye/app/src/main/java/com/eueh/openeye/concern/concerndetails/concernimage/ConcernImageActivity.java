package com.eueh.openeye.concern.concerndetails.concernimage;

import android.content.Intent;
import android.support.v4.view.ViewPager;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;

/**
 * Created by 陈小飞 on 16/12/22.
 */

//ViewPager点击跳转后的界面
public class ConcernImageActivity extends BaseActivity{


    private ViewPager concernVpF;

    @Override
    public int setLayout() {
        return R.layout.activity_image_f;
    }

    @Override
    public void initView() {
        concernVpF = (ViewPager) findViewById(R.id.vp_concern_image_f);
        ConcernImageAdapter imageAdapter = new ConcernImageAdapter(getSupportFragmentManager());
        concernVpF.setAdapter(imageAdapter);
    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("urlMe");


        ConcernImageFragment.Geturl(url);



    }
}
