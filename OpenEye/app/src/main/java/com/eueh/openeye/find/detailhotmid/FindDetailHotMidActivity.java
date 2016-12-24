package com.eueh.openeye.find.detailhotmid;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.find.detailhotmid.day.FindDetailHotMidDayFragment;
import com.eueh.openeye.find.detailhotmid.month.FindDetailHotMidMonthFragment;
import com.eueh.openeye.find.detailhotmid.sum.FindDetailHotMidSumFragment;

import java.util.ArrayList;

public class FindDetailHotMidActivity extends BaseActivity {
    private TabLayout tbFindHot;
    private ViewPager vpFindHot;
    private ArrayList<Fragment>data;


    @Override
    public int setLayout() {
        return R.layout.activity_find_detail_hot_mid;
    }

    @Override
    public void initView() {

        data = new ArrayList<>();
        tbFindHot = (TabLayout) findViewById(R.id.tb_find_hot_mid_g);
        vpFindHot = (ViewPager) findViewById(R.id.vp_find_hot_mid_g);

    }

    @Override
    public void initData() {

        data.add(new FindDetailHotMidDayFragment());
        data.add(new FindDetailHotMidMonthFragment());
        data.add(new FindDetailHotMidSumFragment());
        FindDetailHotMidAdapter adapter = new FindDetailHotMidAdapter(getSupportFragmentManager(),data);
        vpFindHot.setAdapter(adapter);
        tbFindHot.setupWithViewPager(vpFindHot);


        //传过来id  然而 id 并没有用上
        Intent intent = getIntent();
        int idHotGM = intent.getIntExtra("idHotGM",100);
        Log.d("FindDetailHotMidActivit", "idHotGM:" + idHotGM);



    }
}
