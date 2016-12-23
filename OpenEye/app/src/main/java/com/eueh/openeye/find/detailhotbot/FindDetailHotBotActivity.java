package com.eueh.openeye.find.detailhotbot;

import android.content.Intent;
import android.util.Log;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;

public class FindDetailHotBotActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_find_detail_hot_bot;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        int idHotGB = intent.getIntExtra("idHotGB",100);
        Log.d("FindDetailHotBotActivit", "idHotGB:" + idHotGB);
    }
}
