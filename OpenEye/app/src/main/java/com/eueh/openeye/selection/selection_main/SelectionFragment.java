package com.eueh.openeye.selection.selection_main;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.selection.SelectionHeadActivity;
import com.eueh.openeye.selection.selection_main.SelectionAdapter;
import com.eueh.openeye.selection.selection_main.SelectionBean;
import com.eueh.openeye.utils.NetTool;
import com.eueh.openeye.utils.onHttpCallback;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

/**
 * Created by dllo on 16/12/19.
 */

public class SelectionFragment extends BaseFragment {

    private PullToRefreshListView ls;
    private SelectionAdapter myAdapter;
    private String urlSelection;
    private View viewBack;
    private ImageView ivHeadView;

    //定义一个用来存放nextUrl的str
    private String dataNextUrl;
    //数据
    private ArrayList<SelectionBean.ItemListBeanX> dataNextArr ;


    @Override
    public int setLayout() {
        return R.layout.fragment_selection;
    }

    @Override
    public void initView(View view) {
        ls = (PullToRefreshListView) view.findViewById(R.id.ls_selection_fragment);
        myAdapter = new SelectionAdapter(getContext());
        urlSelection = "http://baobab.kaiyanapp.com/api/v4/tabs/selected?udid=a9b538d2cddb40e5abd2424fb94941fedcabfe04&vc=152&vn=3.0.1&deviceModel=Google%20Nexus%205%20-%205.1.0%20-%20API%2022%20-%201080x1920&first_channel=eyepetizer_wandoujia_market&last_channel=eyepetizer_wandoujia_market&system_version_code=22";
        viewBack = LayoutInflater.from(getContext()).inflate(R.layout.headview_selection_fragment, null);
        ivHeadView = (ImageView) viewBack.findViewById(R.id.iv_headview_selection_fragment_d);
        dataNextArr = new ArrayList<>();
    }


    @Override
    public void initData() {
        //第一次加载数据
        initComeInData();
        //添加头文件   并设置点击事件
        addLsHeadView();
        //Pull刷新加载
        myrefresh();


    }

    private void myrefresh() {
//
        ls.setMode(PullToRefreshBase.Mode.BOTH);

        ls.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            //刷新
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                myAdapter.cleanData();
                myAdapter.notifyDataSetChanged();

                NetTool.getInstance().startRequest(urlSelection, SelectionBean.class, new onHttpCallback<SelectionBean>() {
                    @Override
                    public void onSuccess(SelectionBean response) {
                        dataNextArr.clear();
                        dataNextArr = (ArrayList<SelectionBean.ItemListBeanX>) response.getItemList();
                        myAdapter.setData(dataNextArr);
                        ls.onRefreshComplete();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });


            }

            //加载
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {



                NetTool.getInstance().startRequest(dataNextUrl, SelectionBean.class, new onHttpCallback<SelectionBean>() {
                    @Override
                    public void onSuccess(SelectionBean response) {
                        //为了下一次加载
                        dataNextUrl = response.getNextPageUrl();

                        for (int i = 0; i < response.getItemList().size(); i++) {
                            dataNextArr.add(response.getItemList().get(i));
                        }

                        myAdapter.setData(dataNextArr);
                        ls.onRefreshComplete();


                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });



            }
        });

    }


    private void addLsHeadView() {
        //PullToRefresh  增加头布局方法!!!因为Pull不是继承listview  所以先转化成ls
        ls.getRefreshableView().addHeaderView(viewBack);

        ivHeadView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SelectionHeadActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initComeInData() {
        NetTool.getInstance().startRequest(urlSelection, SelectionBean.class, new onHttpCallback<SelectionBean>() {
            @Override
            public void onSuccess(SelectionBean response) {

                dataNextUrl = response.getNextPageUrl();

                dataNextArr = (ArrayList<SelectionBean.ItemListBeanX>) response.getItemList();

                myAdapter.setData(dataNextArr);
                ls.setAdapter(myAdapter);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
