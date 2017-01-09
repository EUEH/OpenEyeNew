package com.eueh.openeye.selection;

import android.content.Intent;
import android.view.View;
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
        ivHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SelectionHeadActivity.this , SelectionSupplementActivity.class);
                startActivity(intent);
            }
        });
    }



}
