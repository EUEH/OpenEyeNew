package com.eueh.openeye.concern;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.eueh.openeye.R;
import com.eueh.openeye.base.BaseFragment;

/**
 * Created by dllo on 16/12/19.
 */

//关注页  陈小飞负责
public class ConcernFragment extends BaseFragment implements View.OnClickListener {

    private ListView lvConcernF;
    private TextView tvF;
    private ImageView ivF;

    @Override
    public int setLayout() {
        return R.layout.fragment_concern;
    }

    @Override
    public void initView(View view) {
        lvConcernF = (ListView) view.findViewById(R.id.lv_concern_f);
        tvF = (TextView) view.findViewById(R.id.tv_concern_f);
        ivF = (ImageView) view.findViewById(R.id.iv_concern_search_f);

        tvF.setOnClickListener(this);
        ivF.setOnClickListener(this);
    }


    @Override
    public void initData() {

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
