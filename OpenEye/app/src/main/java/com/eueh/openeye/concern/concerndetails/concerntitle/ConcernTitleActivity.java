package com.eueh.openeye.concern.concerndetails.concerntitle;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

import java.util.ArrayList;

/**
 * Created by 陈小飞 on 16/12/22.
 */

//title点击跳转后的界面
public class ConcernTitleActivity extends BaseActivity implements View.OnClickListener {

    private TabLayout tabF;
    private ViewPager vpF;
    private ImageView iconF;
    private TextView nameF;
    private TextView briefF;
    private TextView descriptionF;
    private String FRONT_URL = "http://baobab.kaiyanapp.com/api/v3/pgc/videos?pgcId=";
    private String BACK_URL = "&strategy=date&udid=67c75fadad7140dd8d3d3c40cf87685971fd4523&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
    private int id;
    private String url;


    @Override
    public int setLayout() {
        return R.layout.activity_title_f;
    }

    @Override
    public void initView() {
        //获取上个界面传过来的id(拼接接口)
        getId();

        ImageView backF = (ImageView) findViewById(R.id.iv_activity_title_back_f);
        ImageView shareF = (ImageView) findViewById(R.id.iv_activity_title_share_f);
        iconF = (ImageView) findViewById(R.id.iv_activity_title_icon_f);
        nameF = (TextView) findViewById(R.id.tv_activity_title_name_f);
        briefF = (TextView) findViewById(R.id.tv_activity_title_brief_f);
        descriptionF = (TextView) findViewById(R.id.tv_activity_title_description_f);
        tabF = (TabLayout) findViewById(R.id.tab_activity_title_f);
        vpF = (ViewPager) findViewById(R.id.vp_activity_title_f);

        backF.setOnClickListener(this);
        shareF.setOnClickListener(this);
        url = FRONT_URL + id + BACK_URL;

        ArrayList<Fragment> arrayList = new ArrayList<>();
        arrayList.add(new TimeFragment());
        arrayList.add(new ShareFragment());
        ConcernTitleVpAdapter vpAdapter = new ConcernTitleVpAdapter(getSupportFragmentManager());
        vpAdapter.setArrayList(arrayList);
        vpF.setAdapter(vpAdapter);
        tabF.setupWithViewPager(vpF);
    }

    private void getId() {
        Intent intent = getIntent();
        id = intent.getIntExtra("id",200);

        Log.d("ConcernTitleActivity", "id:" + id);
    }

    @Override
    public void initData() {
        getData();
    }

    private void getData() {
        NetTool.getInstance().startRequest(url, ConcernTitleBean.class, new onHttpCallback<ConcernTitleBean>() {
            @Override
            public void onSuccess(ConcernTitleBean response) {
                Glide.with(ConcernTitleActivity.this).load(response.getPgcInfo().getIcon()).into(iconF);
                nameF.setText(response.getPgcInfo().getName());
                briefF.setText(response.getPgcInfo().getBrief());
                descriptionF.setText(response.getPgcInfo().getDescription());
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_activity_title_back_f:
                finish();
                break;
            case R.id.iv_activity_title_share_f:
                break;
        }
    }
}
