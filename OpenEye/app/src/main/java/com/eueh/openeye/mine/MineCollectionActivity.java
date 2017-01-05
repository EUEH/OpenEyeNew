package com.eueh.openeye.mine;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseActivity;
import com.eueh.openeye.selection.selection_detail.SelectionCollection;
import com.eueh.openeye.utils.LiteTool;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 陈焕栋 on 17/1/3.
 */

public class MineCollectionActivity extends BaseActivity {
    private ListView ls;
    private ArrayList<MineCollectionBean> data;
    private MineCollectionAdapter myAdapter;

    @Override
    public int setLayout() {
        return R.layout.activity_mine_collection;
    }

    @Override
    public void initView() {
        ls = (ListView) findViewById(R.id.mine_collection_ls_d);
        data = new ArrayList<>();
        myAdapter = new MineCollectionAdapter(this);
    }

    @Override
    public void initData() {
        //第一次进来加载数据
        initMyData();
        //点击单行删除数据库
        clilsdel();


    }

    private void clilsdel() {
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                List<SelectionCollection> listq = LiteTool.getInstance().queryAll(SelectionCollection.class);
                String picUrl = listq.get(i).getPicUrl();
                LiteTool.getInstance().deleteOne(SelectionCollection.class , "picUrl" , picUrl );

                data.clear();
                List<SelectionCollection> list = LiteTool.getInstance().queryAll(SelectionCollection.class);
                for (int i1 = 0; i1 < list.size(); i1++) {
                    MineCollectionBean bean = new MineCollectionBean();
                    bean.setUrlPic(list.get(i1).getPicUrl());
                    bean.setTitle(list.get(i1).getTitle());
                    bean.setCategory(list.get(i1).getTitle());
                    data.add(bean);
                }
                myAdapter.notifyDataSetChanged();

            }
        });
    }

    private void initMyData() {
        List<SelectionCollection> list = LiteTool.getInstance().queryAll(SelectionCollection.class);
        for (int i = 0; i < list.size(); i++) {
            MineCollectionBean bean = new MineCollectionBean();
            bean.setUrlPic(list.get(i).getPicUrl());
            bean.setTitle(list.get(i).getTitle());
            bean.setCategory(list.get(i).getTitle());
            data.add(bean);
        }
        myAdapter.setData(data);
        ls.setAdapter(myAdapter);

    }
}
