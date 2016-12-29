package com.eueh.openeye.concern;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;
import com.eueh.openeye.R;
import com.eueh.openeye.concern.author.ConcernAuthorActivity;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.search.SearchActivity;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;

import java.util.List;

/**
 * Created by dllo on 16/12/19.
 */

//关注页  陈小飞负责
public class ConcernFragment extends BaseFragment implements View.OnClickListener, OnRefreshListener, OnLoadMoreListener {

    private ListView lvConcernF;
    private TextView tvF;
    private ImageView ivF;
    public static final String CONCERN_URL = "http://baobab.kaiyanapp.com/api/v4/tabs/follow?udid=67c75fadad7140dd8d3d3c40cf87685971fd4523&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
    private ConcernAdapter concernAdapter;
    private SwipeToLoadLayout swipeToLoadLayout;
    public static final String CONCERN_FRONT_URL = "http://baobab.kaiyanapp.com/api/v4/tabs/follow?start=";
    private static String CONCERN_BACK_URL = "&num=2&follow=false&startId=0&udid=67c75fadad7140dd8d3d3c40cf87685971fd4523&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
    int num = 2;
    private String url;
    private List<ConcernBean.ItemListBeanX> list;

    @Override
    public int setLayout() {
        return R.layout.fragment_concern;
    }

    @Override
    public void initView(View view) {
        lvConcernF = (ListView) view.findViewById(R.id.swipe_target);
        tvF = (TextView) view.findViewById(R.id.tv_concern_f);
        ivF = (ImageView) view.findViewById(R.id.iv_concern_search_f);
        concernAdapter = new ConcernAdapter(getActivity());
        tvF.setOnClickListener(this);
        ivF.setOnClickListener(this);

        swipeToLoadLayout = (SwipeToLoadLayout) view.findViewById(R.id.swipeToLoadLayout);
        swipeToLoadLayout.setOnRefreshListener(this);
        swipeToLoadLayout.setOnLoadMoreListener(this);
        url = CONCERN_FRONT_URL + num + CONCERN_BACK_URL;
    }


    @Override
    public void initData() {
        //解析数据
        getData();

        ConcernRvAdapter.getConcernUrl(CONCERN_URL);
    }

    private void getData() {
        NetTool.getInstance().startRequest(CONCERN_URL, ConcernBean.class, new onHttpCallback<ConcernBean>() {
            @Override
            public void onSuccess(ConcernBean response) {
                list = response.getItemList();
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
        switch (view.getId()) {
            case R.id.tv_concern_f:
                Intent intent = new Intent(getActivity(), ConcernAuthorActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_concern_search_f:
                Intent intent1 = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent1);
                break;
        }
    }



    //刷新
    @Override
    public void onRefresh() {
        //必须要写这个
        swipeToLoadLayout.setRefreshing(false);
        NetTool.getInstance().startRequest(CONCERN_URL, ConcernBean.class, new onHttpCallback<ConcernBean>() {
            @Override
            public void onSuccess(ConcernBean response) {
                list = response.getItemList();
                concernAdapter.setList(list);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    //加载
    @Override
    public void onLoadMore() {
        swipeToLoadLayout.setLoadingMore(false);
        NetTool.getInstance().startRequest(url, ConcernBean.class, new onHttpCallback<ConcernBean>() {
            @Override
            public void onSuccess(ConcernBean response) {
                list.addAll(response.getItemList());
                concernAdapter.setList(list);
                num += 2;
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }


}
