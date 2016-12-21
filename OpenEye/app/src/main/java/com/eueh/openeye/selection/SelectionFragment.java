package com.eueh.openeye.selection;

import android.view.View;
import android.widget.ListView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

/**
 * Created by dllo on 16/12/19.
 */

public class SelectionFragment extends BaseFragment {

    private ListView ls ;
    private SelectionAdapter myAdapter ;
    private String urlSelection ;

    @Override
    public int setLayout() {
        return R.layout.fragment_selection;
    }

    @Override
    public void initView(View view) {
        ls = (ListView) view.findViewById(R.id.ls_selection_fragment);
        myAdapter = new SelectionAdapter(getContext());
        urlSelection = "http://baobab.kaiyanapp.com/api/v4/tabs/selected?udid=a9b538d2cddb40e5abd2424fb94941fedcabfe04&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
    }


    @Override
    public void initData() {
        //第一次加载数据
        initComeInData();
    }

    private void initComeInData() {
        NetTool.getInstance().startRequest(urlSelection, SelectionBean.class, new onHttpCallback<SelectionBean>() {
            @Override
            public void onSuccess(SelectionBean response) {
                myAdapter.setData(response);
                ls.setAdapter(myAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
