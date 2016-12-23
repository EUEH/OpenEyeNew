package com.eueh.openeye.find.detailhotmid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;

public class FindDetailHotMidActivity extends BaseActivity {


    @Override
    public int setLayout() {
        return R.layout.activity_find_detail_hot_mid;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        Intent intent = getIntent();
        int idHotGM = intent.getIntExtra("idHotGM",100);
        Log.d("FindDetailHotMidActivit", "idHotGM:" + idHotGM);
    }
}
