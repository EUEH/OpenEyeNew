package com.eueh.openeye.find;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/19.
 */

public class FindFragment extends BaseFragment {
    private ListView lvFindG;
    private FindBeanNextPage dataNext;

    private Banner bannerHead;
    private String urlFind = "http://baobab.kaiyanapp.com/api/v4/tabs/discovery?udid=76f71db946f845809cdefe35b912a7dc13e1094a&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";

    private String nextPageUrl = "http://baobab.kaiyanapp.com/api/v4/tabs/discovery?start=0&num=17";

    @Override
    public int setLayout() {
        return R.layout.fragment_find;
    }

    @Override
    public void initView(View view) {
        lvFindG = (ListView) view.findViewById(R.id.lv_find_g);
    }

    @Override
    public void initData() {
        dataNext = new FindBeanNextPage();
        //解析网络数据

        //解析NextPage网络数据
        findUrlNextPage();
    }

    //解析NextPage网络数据
    private void findUrlNextPage() {
        NetTool.getInstance().startRequest(nextPageUrl, FindBeanNextPage.class, new onHttpCallback<FindBeanNextPage>() {
            @Override
            public void onSuccess(FindBeanNextPage response) {
                dataNext = response;
                findUrl();
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    //解析URL
    private void findUrl() {
        NetTool.getInstance().startRequest(urlFind, FindBean.class, new onHttpCallback<FindBean>() {
            @Override
            public void onSuccess(FindBean response) {
                //给适配器的数据

                FindAdapter findAdapter = new FindAdapter(getContext());
                findAdapter.setData(response, dataNext);
                lvFindG.setAdapter(findAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

}
