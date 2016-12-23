package com.eueh.openeye.find.detailrechot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

public class FindDetailHotActivity extends BaseActivity {


    private String detailHotUrl;

    @Override
    public int setLayout() {
        return R.layout.activity_find_detail_hot;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        int idHotG = intent.getIntExtra("idHotG",100);
        Log.d("FindDetailHotActivity", "idHotG:" + idHotG);

        detailHotUrl = "http://baobab.kaiyanapp.com/api/v4/categories/detail?id=" +idHotG +"&udid=76f71db946f845809cdefe35b912a7dc13e1094a&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";

        redUrl();
    }

    private void redUrl() {
        NetTool.getInstance().startRequest(detailHotUrl, FindDetailHotBean.class, new onHttpCallback<FindDetailHotBean>() {
            @Override
            public void onSuccess(FindDetailHotBean response) {
                Log.d("FindDetailHotActivity1", "response.getItemList().size():" + response.getItemList().size());
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }


}
