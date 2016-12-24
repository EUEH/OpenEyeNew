package com.eueh.openeye.concern;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

import java.util.List;

/**
 * Created by dllo on 16/12/19.
 */

//关注页  陈小飞负责
public class ConcernFragment extends BaseFragment implements View.OnClickListener {

    private ListView lvConcernF;
    private TextView tvF;
    private ImageView ivF;
    public static final String CONCERN_URL = "http://baobab.kaiyanapp.com/api/v4/tabs/follow?udid=67c75fadad7140dd8d3d3c40cf87685971fd4523&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
    private ConcernAdapter concernAdapter;

    @Override
    public int setLayout() {
        return R.layout.fragment_concern;
    }

    @Override
    public void initView(View view) {
        lvConcernF = (ListView) view.findViewById(R.id.lv_concern_f);
        tvF = (TextView) view.findViewById(R.id.tv_concern_f);
        ivF = (ImageView) view.findViewById(R.id.iv_concern_search_f);
        concernAdapter = new ConcernAdapter(getActivity());
        tvF.setOnClickListener(this);
        ivF.setOnClickListener(this);
    }


    @Override
    public void initData() {
        //解析数据
        getData();
    }

    private void getData() {
        NetTool.getInstance().startRequest(CONCERN_URL, ConcernBean.class, new onHttpCallback<ConcernBean>() {
            @Override
            public void onSuccess(ConcernBean response) {
                final List<ConcernBean.ItemListBeanX> list = response.getItemList();
                concernAdapter.setList(list);
                lvConcernF.setAdapter(concernAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_concern_f:
                Intent intent = new Intent();
                break;
            case R.id.iv_concern_search_f:
                break;
        }
    }
}
