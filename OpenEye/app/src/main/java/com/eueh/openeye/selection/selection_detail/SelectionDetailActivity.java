package com.eueh.openeye.selection.selection_detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.eueh.openeye.R;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

public class SelectionDetailActivity extends AppCompatActivity {
    private String url;
    private SelectionDetailAdapter myAdapter;
    private ViewPager vp ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_detail);

        initMyView();
        initMyData();

    }

    private void initMyData() {


        NetTool.getInstance().startRequest(url, SelectionDetailBean.class, new onHttpCallback<SelectionDetailBean>() {
            @Override
            public void onSuccess(SelectionDetailBean response) {

                myAdapter.setData(response);
                vp.setAdapter(myAdapter);

////////////////////////在这里面改变  把传过来的位置的值设置上 需要写在设置适配器之后
                Intent intent = getIntent() ;
                int vpItem = intent.getIntExtra("selection_viewpager_item_d" , 1 );

                    vp.setCurrentItem(vp.getCurrentItem()+vpItem);


            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void initMyView() {
        myAdapter = new SelectionDetailAdapter(getSupportFragmentManager());
        vp = (ViewPager) findViewById(R.id.sel_detail_vp);

        url = "http://baobab.kaiyanapp.com/api/v2/feed?num=1&udid=a9b538d2cddb40e5abd2424fb94941fedcabfe04&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";






    }


}

