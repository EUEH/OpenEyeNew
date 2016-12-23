package com.eueh.openeye.selection;

import android.widget.ImageView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.selection.selection_main.SelectionMyStyView;

public class SelectionHeadActivity extends BaseActivity {
    private ImageView ivHead ;
    private SelectionMyStyView myView ;

    @Override
    public int setLayout() {
        return R.layout.activity_selection_head;
    }

    @Override
    public void initView() {
        ivHead = (ImageView) findViewById(R.id.iv_headview_selaty_d);
        myView = (SelectionMyStyView) findViewById(R.id.selection_myview_d);
    }

    @Override
    public void initData() {
        myView.setIv(ivHead);
    }
}
