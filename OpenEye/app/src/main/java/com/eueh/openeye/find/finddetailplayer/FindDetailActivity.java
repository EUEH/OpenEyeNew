package com.eueh.openeye.find.finddetailplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.eueh.openeye.R;
import com.eueh.openeye.selection.selection_detail.SelectionDetailAdapter;
import com.eueh.openeye.selection.selection_detail.SelectionDetailBean;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

public class FindDetailActivity extends AppCompatActivity {
    private String url;
    private FindDetailAdapter myAdapter;
    private ViewPager vp;
    private int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_detail);

        initMyView();
        initMyData();

    }

    private void initMyData() {

        Intent intent = getIntent();
        url = intent.getStringExtra("url");
        a = intent.getIntExtra("pos",0);


        NetTool.getInstance().startRequest(url, FindPlayerDetailBean.class, new onHttpCallback<FindPlayerDetailBean>() {
            @Override
            public void onSuccess(FindPlayerDetailBean response) {

                myAdapter.setData(response);
                vp.setAdapter(myAdapter);

////////////////////////在这里面改变  把传过来的位置的值设置上 需要写在设置适配器之后

                vp.setCurrentItem(vp.getCurrentItem()+ a);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void initMyView() {
        myAdapter = new FindDetailAdapter(getSupportFragmentManager());

        vp = (ViewPager) findViewById(R.id.sel_detail_vp);


    }


}

