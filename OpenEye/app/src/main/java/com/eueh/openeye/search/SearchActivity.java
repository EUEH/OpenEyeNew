package com.eueh.openeye.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;

public class SearchActivity extends BaseActivity implements TextView.OnEditorActionListener {
    private EditText etSearch;
    private ListView lvSearch;

    @Override
    public int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        etSearch = (EditText) findViewById(R.id.et_search);
        lvSearch = (ListView) findViewById(R.id.lv_search);

        //监听回车
        etSearch.setOnEditorActionListener(this);

    }

    @Override
    public void initData() {



    }
    //监听回车
    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if ((keyEvent != null && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)){

            String urlSearch = "";

            return true;
        }
        return false;
    }
}
