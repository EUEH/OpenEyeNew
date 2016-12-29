package com.eueh.openeye.mine;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;
import com.eueh.openeye.clear.DataCleanManager;
import com.eueh.openeye.clear.MyClearActivity;

/**
 * Created by dllo on 16/12/19.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {
    private TextView tvDownLoad;
    private String num;

    @Override
    public int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View view) {

        tvDownLoad = (TextView) view.findViewById(R.id.tv_mine_download);
        tvDownLoad.setOnClickListener(this);
    }


    @Override
    public void initData() {


    }

    //跳转到缓存
    @Override
    public void onClick(View view) {

        Intent intent = new Intent(getContext(), MyClearActivity.class);

        try {
            num = DataCleanManager.getTotalCacheSize(getContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        intent.putExtra("num", "缓存大小" + num);
        startActivity(intent);
    }
}
