package com.eueh.openeye.find.detailhotbot.time;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.find.detailhotbot.FindDetailHotBotBean;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;


/**
 * Created by Even on 16/12/24.
 */

public class FindBotTimeFragment extends BaseFragment {
    private RecyclerView lvFindTime;
    private static String urlTimeG;

    @Override
    public int setLayout() {
        return R.layout.fragment_find_hot_bot_me_g;
    }

    @Override
    public void initView(View view) {

        lvFindTime = (RecyclerView) view.findViewById(R.id.lv_find_hot_bot_me_g);


    }
    //接收传过来的ID
    public static int idTime(int id){
        urlTimeG = "http://baobab.kaiyanapp.com/api/v3/pgc/videos?pgcId="+id+"&strategy=date&udid=76f71db946f845809cdefe35b912a7dc13e1094a&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";

        return id;
    }

    @Override
    public void initData() {

        redUrl();

    }

    private void redUrl() {
        NetTool.getInstance().startRequest(urlTimeG, FindDetailHotBotBean.class, new onHttpCallback<FindDetailHotBotBean>() {
            @Override
            public void onSuccess(FindDetailHotBotBean response) {


                FindTimeAdapterR adapterR = new FindTimeAdapterR(getContext());
                adapterR.setData(response);
                lvFindTime.setLayoutManager(new LinearLayoutManager(getContext()));
                lvFindTime.setAdapter(adapterR);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }




}
