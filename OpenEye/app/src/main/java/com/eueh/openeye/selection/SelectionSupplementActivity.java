package com.eueh.openeye.selection;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;


/**
 * Created by 陈焕栋 on 17/1/7.
 */

public class SelectionSupplementActivity extends BaseActivity implements View.OnTouchListener {

    private ViewGroup vg ;
    private LinearLayout ll ;
    private int _yDelta ;


    @Override
    public int setLayout() {
        return R.layout.activity_selection_supplement;
    }

    @Override
    public void initView() {
        vg = (ViewGroup) findViewById(R.id.selection_supplement_vg);
        ll = (LinearLayout) findViewById(R.id.selection_supplement_ll);
    }

    @Override
    public void initData() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                1080, 4000);
        layoutParams.topMargin = 1500;
        ll.setLayoutParams(layoutParams);
        ll.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int Y = (int) motionEvent.getRawY();
        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK) {
            case MotionEvent.ACTION_DOWN:
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                _yDelta = Y - layoutParams.topMargin;
                break;
            case MotionEvent.ACTION_MOVE:
                RelativeLayout.LayoutParams layoutParams1 = (RelativeLayout.LayoutParams) view.getLayoutParams();
                int dis = Y - _yDelta;
                if (dis > 1600){
                    dis = 1600 ;
                }else if (dis < 800){
                    dis = 800 ;
                }
                layoutParams1.topMargin = dis;
                view.setLayoutParams(layoutParams1);
                break;
        }
        vg.invalidate();

        return true;
    }
}






