package com.eueh.openeye.find.detailrechot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

public class FindDetailHotActivity extends BaseActivity {
    private ImageView ivFindDetailHotHead;
    private ListView lvFindHotG;


    private String detailHotUrl;
    private String nextPageUrl;


    private FindDetailHotAdapter adapter;


    @Override
    public int setLayout() {
        return R.layout.activity_find_detail_hot;
    }

    @Override
    public void initView() {


        ivFindDetailHotHead = (ImageView) findViewById(R.id.iv_find_detail_hot_head);
        lvFindHotG = (ListView) findViewById(R.id.lv_find_hot_g);

    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        int idHotG = intent.getIntExtra("idHotG", 100);
        Log.d("FindDetailHotActivity", "idHotG:" + idHotG);

        detailHotUrl = "http://baobab.kaiyanapp.com/api/v4/categories/detail?id=" + idHotG + "&udid=76f71db946f845809cdefe35b912a7dc13e1094a&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";

        redUrl();
    }

    //在这个接口解析里  设置适配器等操作
    private void redUrlNext(final FindDetailHotBean responseUrl) {

        NetTool.getInstance().startRequest(nextPageUrl, FindDetailHotNextBean.class, new onHttpCallback<FindDetailHotNextBean>() {
            @Override
            public void onSuccess(FindDetailHotNextBean response) {

                adapter = new FindDetailHotAdapter(FindDetailHotActivity.this);
                adapter.setData(responseUrl, response);
                //顶部图片
                Glide.with(FindDetailHotActivity.this).load(responseUrl.getCategoryInfo().getHeaderImage()).into(ivFindDetailHotHead);
                lvFindHotG.setAdapter(adapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void redUrl() {
        NetTool.getInstance().startRequest(detailHotUrl, FindDetailHotBean.class, new onHttpCallback<FindDetailHotBean>() {
            @Override
            public void onSuccess(FindDetailHotBean response) {
                nextPageUrl = response.getNextPageUrl();

                //给解析的而数据传给  redUrlNext
                redUrlNext(response);


            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }


}
