package com.eueh.openeye.concern.concerndetails.concerntitle;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

import java.util.List;

/**
 * Created by 陈小飞 on 16/12/23.
 */
public class ConcernShareFragment extends BaseFragment {

    private RecyclerView rvShareF;
    private String FRONT_URL = "http://baobab.kaiyanapp.com/api/v3/pgc/videos?pgcId=";
    private String BACK_URL= "&strategy=shareCount&udid=67c75fadad7140dd8d3d3c40cf87685971fd4523&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
    private String url;


    @Override
    public int setLayout() {
        return R.layout.fragment_share_f;
    }

    @Override
    public void initView(View view) {
        rvShareF = (RecyclerView) view.findViewById(R.id.rv_activity_share_f);
        Intent intent = getActivity().getIntent();
        int a = intent.getIntExtra("id", 200);
        url = FRONT_URL + a + BACK_URL;
        Log.d("ConcernShareFragment", url);
    }

    @Override
    public void initData() {
        NetTool.getInstance().startRequest(url, ConcernShareBean.class, new onHttpCallback<ConcernShareBean>() {
            @Override
            public void onSuccess(ConcernShareBean response) {
                List<ConcernShareBean.ItemListBean> list = response.getItemList();
                ConcernShareAdapter shareAdapter = new ConcernShareAdapter(getActivity());
                shareAdapter.setList(list);
                LinearLayoutManager manager = new LinearLayoutManager(getContext());
                rvShareF.setLayoutManager(manager);
                rvShareF.setAdapter(shareAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
