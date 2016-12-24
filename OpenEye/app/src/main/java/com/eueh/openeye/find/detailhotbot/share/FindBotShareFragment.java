package com.eueh.openeye.find.detailhotbot.share;

import android.os.Bundle;
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

public class FindBotShareFragment extends BaseFragment {
   private RecyclerView rvShare;
    private static String urlShare;

    @Override
    public int setLayout() {
        return R.layout.fragment_find_hot_bot_me_g;
    }

    @Override
    public void initView(View view) {

        rvShare = (RecyclerView) view.findViewById(R.id.lv_find_hot_bot_me_g);

    }
    public static int idShare(int id){
        urlShare = "http://baobab.kaiyanapp.com/api/v3/pgc/videos?pgcId="+id+"&strategy=shareCount&udid=76f71db946f845809cdefe35b912a7dc13e1094a&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";

        Log.d("FindBotTimeFragment", "idShare:" + id);
        return id;
    }

    @Override
    public void initData() {

        NetTool.getInstance().startRequest(urlShare, FindDetailHotBotBean.class, new onHttpCallback<FindDetailHotBotBean>() {
            @Override
            public void onSuccess(FindDetailHotBotBean response) {
                FindShareAdapterR adapterR = new FindShareAdapterR(getContext());
                adapterR.setData(response);
                rvShare.setAdapter(adapterR);
                rvShare.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }


}
