package com.eueh.openeye.find.detailhotmid.month;

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

public class FindDetailHotMidMonthFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    private ListView lvMonth;
    private String urlMonth = "http://baobab.kaiyanapp.com/api/v3/ranklist?num=10&strategy=monthly&udid=76f71db946f845809cdefe35b912a7dc13e1094a&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22 ";
    @Override
    public int setLayout() {
        return R.layout.fragment_find_detail_hot_mid_month;
    }

    @Override
    public void initView(View view) {
        lvMonth = (ListView) view.findViewById(R.id.lv_find_month_g);

        lvMonth.setOnItemClickListener(this);
    }

    @Override
    public void initData() {

        redUrl();
    }

    private void redUrl() {
        NetTool.getInstance().startRequest(urlMonth, FindMonthBean.class, new onHttpCallback<FindMonthBean>() {
            @Override
            public void onSuccess(FindMonthBean response) {
                FindMonthAdapter adapter = new FindMonthAdapter(getContext());
                adapter.setData(response);
                lvMonth.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent = new Intent(getContext(), FindDetailActivity.class);
        intent.putExtra("url",urlMonth);
        intent.putExtra("pos",i);
        startActivity(intent);
    }
}
