package com.eueh.openeye.find.detailhotmid.sum;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.find.finddetailplayer.FindDetailActivity;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

/**
 * Created by Even on 16/12/23.
 */

public class FindDetailHotMidSumFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private ListView lvSum;

    private String sumUrl = "http://baobab.kaiyanapp.com/api/v3/ranklist?num=10&strategy=historical&udid=76f71db946f845809cdefe35b912a7dc13e1094a&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22 ";
    @Override
    public int setLayout() {
        return R.layout.fragment_find_detail_hot_mid_sum;
    }

    @Override
    public void initView(View view) {
        lvSum = (ListView) view.findViewById(R.id.lv_find_sum_g);
        lvSum.setOnItemClickListener(this);
    }

    @Override
    public void initData() {

        redUrl();
    }

    private void redUrl() {
        NetTool.getInstance().startRequest(sumUrl, FindSumBean.class, new onHttpCallback<FindSumBean>() {
            @Override
            public void onSuccess(FindSumBean response) {
                FindSumAdapter adapter = new FindSumAdapter(getContext());
                adapter.setData(response);
                lvSum.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getContext(), FindDetailActivity.class);
        intent.putExtra("url",sumUrl);
        intent.putExtra("pos",i);
        startActivity(intent);
    }
}
