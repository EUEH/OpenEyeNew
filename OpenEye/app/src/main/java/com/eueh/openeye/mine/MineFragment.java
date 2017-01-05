package com.eueh.openeye.mine;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;

/**
 * Created by dllo on 16/12/19.
 */

public class MineFragment extends BaseFragment implements View.OnClickListener {
    private TextView tvCollect;

    @Override
    public int setLayout() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView(View view) {
        tvCollect = (TextView) view.findViewById(R.id.mine_collect_tv_d);
    }


    @Override
    public void initData() {
        //点击我的收藏进入收藏页面
        cliCollection();

    }

    private void cliCollection() {
        tvCollect.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_collect_tv_d:
                Intent intent = new Intent(getContext() , MineCollectionActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.mine_collection_anim , R.anim.mine_collection_anim);
                break;
        }
    }

}
