package com.eueh.openeye;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.eueh.openeye.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {
    private ImageView ivWelcome;
    private TimeCount time;


    @Override
    public int setLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initView() {
        ivWelcome = (ImageView) findViewById(R.id.iv_welcome);
        ivWelcome.setImageResource(R.mipmap.ic_launcher);

    }

    @Override
    public void initData() {

        time = new TimeCount(3000, 1000);
        time.start();

    }

    class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long l) {

        }

        @Override
        public void onFinish() {

            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
