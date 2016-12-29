package com.eueh.openeye.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

public class SearchActivity extends BaseActivity implements TextView.OnEditorActionListener {
    private EditText etSearch;
    private ListView lvSearch;
    private String urlSearch;

    private TextView tvMeLeft,tvMeRight;

    @Override
    public int setLayout() {
        return R.layout.activity_search;
    }

    @Override
    public void initView() {
        etSearch = (EditText) findViewById(R.id.et_search);
        lvSearch = (ListView) findViewById(R.id.lv_search);

        tvMeLeft = (TextView) findViewById(R.id.tv_search_me_left);
        tvMeRight = (TextView) findViewById(R.id.tv_search_me_right);

        //监听回车
        etSearch.setOnEditorActionListener(this);

    }

    @Override
    public void initData() {



    }

    //监听回车
    @Override
    public boolean onEditorAction(final TextView textView, int i, KeyEvent keyEvent) {
        if ((keyEvent != null && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {

            String num = etSearch.getText().toString();
            urlSearch = "http://baobab.kaiyanapp.com/api/v1/search?query=" + num + "&udid=76f71db946f845809cdefe35b912a7dc13e1094a&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";

            NetTool.getInstance().startRequest(urlSearch, SearchBean.class, new onHttpCallback<SearchBean>() {
                @Override
                public void onSuccess(SearchBean response) {
                    tvMeLeft.setText("-["+response.getCount()+"]-");
                    tvMeRight.setText("搜索结果共"+response.getTotal()+"个-");

                    SearchAdapter adapter = new SearchAdapter(SearchActivity.this);
                    adapter.setData(response);
                    lvSearch.setAdapter(adapter);
                }

                @Override
                public void onError(Throwable e) {

                }
            });

            return true;
        }
        return false;
    }
}
