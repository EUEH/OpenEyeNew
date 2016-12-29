package com.eueh.openeye.clear;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;

public class MyClearActivity extends BaseActivity implements View.OnClickListener {
    private TextView tvLeft,tvRight;


    @Override
    public int setLayout() {
        return R.layout.activity_my_clear;
    }

    @Override
    public void initView() {
        tvLeft = (TextView) findViewById(R.id.tv_clear_left);
        tvRight = (TextView) findViewById(R.id.tv_clear_right);
        tvLeft.setOnClickListener(this);

    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        String num = intent.getStringExtra("num");

        tvRight.setText(num);
    }

    @Override
    public void onClick(View view) {
        DataCleanManager.clearAllCache(this);
        try {
            tvRight.setText(DataCleanManager.getTotalCacheSize(this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
