package com.eueh.openeye.find.detailhotbot;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.find.detailhotbot.share.FindBotShareFragment;
import com.eueh.openeye.find.detailhotbot.time.FindBotTimeFragment;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

import java.util.ArrayList;

public class FindDetailHotBotActivity extends BaseActivity {
    private ViewPager vpHotBot;
    private TabLayout tbHotBot;
    private ImageView ivHotBot;
    private TextView tvHotBotTop, tvHotBotMid, tvHotBotBot;
    private ArrayList<Fragment> data;
    private int idHotGB;
    private Intent intent;
    private String myTimeUrl;


    @Override
    public int setLayout() {

        return R.layout.activity_find_detail_hot_bot;
    }

    @Override
    public void initView() {

        vpHotBot = (ViewPager) findViewById(R.id.vp_find_hot_bot);
        tbHotBot = (TabLayout) findViewById(R.id.tb_find_hot_bot);

        ivHotBot = (ImageView) findViewById(R.id.iv_find_hot_bot);
        tvHotBotTop = (TextView) findViewById(R.id.tv_find_hot_bot_top);
        tvHotBotMid = (TextView) findViewById(R.id.tv_find_hot_bot_mid);
        tvHotBotBot = (TextView) findViewById(R.id.tv_find_hot_bot_bot);


    }

    @Override
    public void initData() {
        intent = getIntent();
        idHotGB = intent.getIntExtra("idHotGB", 100);

        myTimeUrl = "http://baobab.kaiyanapp.com/api/v3/pgc/videos?pgcId=" + idHotGB + "&strategy=shareCount&udid=76f71db946f845809cdefe35b912a7dc13e1094a&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";

        //给fragment传值
        FindBotTimeFragment.idTime(idHotGB);
        FindBotShareFragment.idShare(idHotGB);

        data = new ArrayList<>();
        data.add(new FindBotTimeFragment());
        data.add(new FindBotShareFragment());

        FindDetailHotBotAdapter adapter = new FindDetailHotBotAdapter(getSupportFragmentManager(), data);

        vpHotBot.setAdapter(adapter);
        tbHotBot.setupWithViewPager(vpHotBot);

        redUrl();
    }

    private void redUrl() {

        NetTool.getInstance().startRequest(myTimeUrl, FindDetailHotBotBean.class, new onHttpCallback<FindDetailHotBotBean>() {
            @Override
            public void onSuccess(FindDetailHotBotBean response) {

                Glide.with(FindDetailHotBotActivity.this).load(response.getPgcInfo().getIcon()).into(ivHotBot);
                tvHotBotTop.setText(response.getPgcInfo().getName());
                tvHotBotMid.setText(response.getPgcInfo().getBrief());
                tvHotBotBot.setText(response.getPgcInfo().getDescription());
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }


}
